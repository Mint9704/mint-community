package com.mint.subject.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.basic.entity.SubjectLabel;

public interface SubjectLabelService extends IService<SubjectLabel> {
    int add(SubjectLabel subjectLabel);

    int update(SubjectLabel subjectLabel);

    int delete(Long id);

    SubjectLabel get(Long id);

    IPage<SubjectLabel> list(SubjectLabel subjectLabel, long pageNum, long pageSize);
}
