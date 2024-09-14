package com.mint.subject.domain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mint.subject.convert.SubjectInfoConverter;
import com.mint.subject.domain.handler.SubjectTypeHandler;
import com.mint.subject.domain.handler.SubjectTypeHandlerFactory;
import com.mint.subject.domain.service.SubjectInfoDomainService;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.entity.SubjectLabel;
import com.mint.subject.entity.SubjectMapping;
import com.mint.subject.infra.basic.service.SubjectInfoService;
import com.mint.subject.infra.basic.service.SubjectLabelService;
import com.mint.subject.infra.basic.service.SubjectMappingService;
import com.mint.subject.vo.SubjectInfoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Mint
 * @Create 2024/8/30
 */
@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {
    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Override
    @Transactional
    public void add(SubjectInfoDTO subjectInfoDTO) {
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertSubjectInfoDTO2SubjectInfo(subjectInfoDTO);
        subjectInfoService.save(subjectInfo);
        subjectInfoDTO.setId(subjectInfo.getId());

        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoDTO.getSubjectType());
        handler.add(subjectInfoDTO);

        List<SubjectMapping> mappingList = new ArrayList<>();
        List<Long> categoryIdList = subjectInfoDTO.getCategoryIds();
        List<Long> labelIdList = subjectInfoDTO.getLabelIds();
        categoryIdList.forEach(
           categoryId -> {
               labelIdList.forEach(
                   labelId -> {
                       SubjectMapping mapping = new SubjectMapping();
                       mapping.setSubjectId(subjectInfo.getId());
                       mapping.setCategoryId(categoryId);
                       mapping.setLabelId(labelId);
                       mappingList.add(mapping);
                   }
               );
           }
        );
        subjectMappingService.saveBatch(mappingList);
    }

    @Override
    public SubjectInfoVO get(Long id) {
        SubjectInfo subjectInfo = subjectInfoService.getById(id);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectInfoVO subjectInfoVO = SubjectInfoConverter.INSTANCE.convertSubjectInfo2SubjectInfoVO(subjectInfo);
        return handler.get(subjectInfoVO);
    }

    @Override
    public IPage<SubjectInfoVO> page(SubjectInfoDTO subjectInfoDTO) {
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(subjectInfoDTO.getCategoryId());
        subjectMapping.setLabelId(subjectInfoDTO.getLabelId());
        List<Long> subjectIdList = subjectMappingService.querySubjectIds(subjectMapping);
        Page<SubjectInfoVO> result = new Page<>(subjectInfoDTO.getPageNum(), subjectInfoDTO.getPageSize(), subjectIdList.size());
        // 若不存在数据，则直接返回
        if (CollectionUtils.isEmpty(subjectIdList)) {
            return result;
        }

        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertSubjectInfoDTO2SubjectInfo(subjectInfoDTO);
        int start = (subjectInfoDTO.getPageNum() - 1) * subjectInfoDTO.getPageSize();
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoDTO.getCategoryId(), subjectInfoDTO.getLabelId(), start, subjectInfoDTO.getPageSize());
        List<SubjectInfoVO> subjectInfoVOList = SubjectInfoConverter.INSTANCE.convertSubjectInfoList2VoList(subjectInfoList);
        // 查询每条数据对应的全部标签
        subjectInfoVOList.forEach(
            l -> {
                SubjectMapping mapping = new SubjectMapping();
                mapping.setSubjectId(l.getId());
                List<Long> labelIdList = subjectMappingService.queryLabelIds(mapping);
                List<SubjectLabel> subjectLabelList = subjectLabelService.queryByIds(labelIdList);
                List<String> labelNames = subjectLabelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
                l.setLabelNames(labelNames);
            }
        );
        result.setRecords(subjectInfoVOList);
        return result;
    }
}
