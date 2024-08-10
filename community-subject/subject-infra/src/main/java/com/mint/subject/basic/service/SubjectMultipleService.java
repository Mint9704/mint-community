package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectMultiple;

public interface SubjectMultipleService extends IService<SubjectMultiple> {
    int add(SubjectMultiple subjectMultiple);

    int update(SubjectMultiple subjectMultiple);

    int delete(Long id);

    SubjectMultiple get(Long id);

    IPage<SubjectMultiple> list(SubjectMultiple subjectMultiple, long pageNum, long pageSize);
}
