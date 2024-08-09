package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.basic.entity.SubjectCategory;

public interface SubjectCategoryService extends IService<SubjectCategory> {
    int add(SubjectCategory subjectInfo);

    int update(SubjectCategory subjectInfo);

    int delete(Long id);

    SubjectCategory get(Long id);

    IPage<SubjectCategory> list(SubjectCategory subjectInfo, long pageNum, long pageSize);
}
