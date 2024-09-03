package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectBrief;


public interface SubjectBriefService extends IService<SubjectBrief> {
    IPage<SubjectBrief> list(SubjectBrief subjectBrief, long pageNum, long pageSize);
}
