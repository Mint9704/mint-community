package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectRadio;

public interface SubjectRadioService extends IService<SubjectRadio> {
    int add(SubjectRadio subjectRadio);

    int update(SubjectRadio subjectRadio);

    int delete(Long id);

    SubjectRadio get(Long id);

    IPage<SubjectRadio> list(SubjectRadio subjectRadio, long pageNum, long pageSize);
}
