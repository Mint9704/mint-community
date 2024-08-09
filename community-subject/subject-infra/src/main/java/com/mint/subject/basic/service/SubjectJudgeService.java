package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.basic.entity.SubjectJudge;

public interface SubjectJudgeService extends IService<SubjectJudge> {
    int add(SubjectJudge subjectJudge);

    int update(SubjectJudge subjectJudge);

    int delete(Long id);

    SubjectJudge get(Long id);

    IPage<SubjectJudge> list(SubjectJudge subjectJudge, long pageNum, long pageSize);
}
