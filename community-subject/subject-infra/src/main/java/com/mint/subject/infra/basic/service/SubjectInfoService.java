package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectInfo;

public interface SubjectInfoService extends IService<SubjectInfo> {
    IPage<SubjectInfo> list(SubjectInfo subjectInfo, long pageNum, long pageSize);
}
