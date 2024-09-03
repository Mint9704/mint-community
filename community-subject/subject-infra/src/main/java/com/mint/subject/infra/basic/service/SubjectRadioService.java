package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectRadio;

import java.util.List;

public interface SubjectRadioService extends IService<SubjectRadio> {
    IPage<SubjectRadio> list(SubjectRadio subjectRadio, long pageNum, long pageSize);
}
