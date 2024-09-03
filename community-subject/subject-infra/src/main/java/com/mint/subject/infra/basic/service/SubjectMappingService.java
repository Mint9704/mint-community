package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectMapping;

import java.util.List;

public interface SubjectMappingService extends IService<SubjectMapping> {
    List<Long> queryLabelIds(SubjectMapping subjectMapping);
}
