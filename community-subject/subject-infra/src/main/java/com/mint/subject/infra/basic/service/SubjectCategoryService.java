package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryService extends IService<SubjectCategory> {
    int add(SubjectCategory subjectInfo);

    int update(SubjectCategory subjectInfo);

    int delete(Long id);

    SubjectCategory get(Long id);

    List<SubjectCategory> list(SubjectCategory subjectCategory);
}
