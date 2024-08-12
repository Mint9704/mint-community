package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectMapping;

import java.util.List;

public interface SubjectMappingService extends IService<SubjectMapping> {
    int add(SubjectMapping subjectMapping);

    void batchAdd(List<SubjectMapping> list);

    int update(SubjectMapping subjectMapping);

    int delete(Long id);

    SubjectMapping get(Long id);

    List<Long> queryLabelIds(SubjectMapping subjectMapping);
}
