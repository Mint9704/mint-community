package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectJudge;

public interface SubjectJudgeService extends IService<SubjectJudge> {
    IPage<SubjectJudge> list(SubjectJudge subjectJudge, long pageNum, long pageSize);
}
