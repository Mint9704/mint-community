package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.web.enums.IsDeletedEnum;
import com.mint.subject.entity.SubjectMapping;
import com.mint.subject.infra.basic.mapper.SubjectMappingMapper;
import com.mint.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping> implements SubjectMappingService {
    @Override
    public List<Long> queryLabelIds(SubjectMapping subjectMapping) {
        QueryWrapper<SubjectMapping> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct label_id");
        queryWrapper.eq("is_deleted", IsDeletedEnum.UN_DELETED.getCode());
        if (subjectMapping.getSubjectId() != null) {
            queryWrapper.eq("subject_id", subjectMapping.getSubjectId());
        }
        if (subjectMapping.getCategoryId() != null) {
            queryWrapper.eq("category_id", subjectMapping.getCategoryId());
        }
        if (subjectMapping.getLabelId() != null) {
            queryWrapper.eq("label_id", subjectMapping.getLabelId());
        }

        return this.list(queryWrapper)
                .stream()
                .map(SubjectMapping::getLabelId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> querySubjectIds(SubjectMapping subjectMapping) {
        QueryWrapper<SubjectMapping> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct subject_id");
        queryWrapper.eq("is_deleted", IsDeletedEnum.UN_DELETED.getCode());
        if (subjectMapping.getCategoryId() != null) {
            queryWrapper.eq("category_id", subjectMapping.getCategoryId());
        }
        if (subjectMapping.getLabelId() != null) {
            queryWrapper.eq("label_id", subjectMapping.getLabelId());
        }

        return this.list(queryWrapper)
                .stream()
                .map(SubjectMapping::getSubjectId)
                .collect(Collectors.toList());
    }
}
