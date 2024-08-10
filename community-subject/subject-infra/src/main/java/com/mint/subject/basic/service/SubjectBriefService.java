package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectBrief;


public interface SubjectBriefService extends IService<SubjectBrief> {
    int add(SubjectBrief subjectBrief);

    int update(SubjectBrief subjectBrief);

    int delete(Long id);

    SubjectBrief get(Long id);

    IPage<SubjectBrief> list(SubjectBrief subjectBrief, long pageNum, long pageSize);
}
