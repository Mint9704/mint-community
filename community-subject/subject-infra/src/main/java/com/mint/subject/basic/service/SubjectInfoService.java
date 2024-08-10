package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectInfo;

public interface SubjectInfoService extends IService<SubjectInfo> {
    int add(SubjectInfo subjectInfo);

    int update(SubjectInfo subjectInfo);

    int delete(Long id);

    SubjectInfo get(Long id);

    IPage<SubjectInfo> list(SubjectInfo subjectInfo, long pageNum, long pageSize);
}
