package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectMapping;

public interface SubjectMappingService extends IService<SubjectMapping> {
    int add(SubjectMapping subjectMapping);

    int update(SubjectMapping subjectMapping);

    int delete(Long id);

    SubjectMapping get(Long id);
}
