package com.mint.subject.domain.service.impl;

import com.mint.subject.convert.SubjectInfoConverter;
import com.mint.subject.domain.handler.SubjectTypeHandler;
import com.mint.subject.domain.handler.SubjectTypeHandlerFactory;
import com.mint.subject.domain.service.SubjectInfoDomainService;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.entity.SubjectMapping;
import com.mint.subject.infra.basic.service.SubjectInfoService;
import com.mint.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
}
