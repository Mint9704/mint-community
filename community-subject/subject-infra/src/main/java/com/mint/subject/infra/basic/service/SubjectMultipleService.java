package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectMultiple;

import java.util.List;

public interface SubjectMultipleService extends IService<SubjectMultiple> {
    IPage<SubjectMultiple> list(SubjectMultiple subjectMultiple, long pageNum, long pageSize);
}
