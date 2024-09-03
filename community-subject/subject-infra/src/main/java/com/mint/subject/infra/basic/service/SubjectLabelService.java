package com.mint.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectLabel;

import java.util.List;

public interface SubjectLabelService extends IService<SubjectLabel> {
    List<SubjectLabel> list(SubjectLabel subjectLabel);

    List<SubjectLabel> queryByIds(List<Long> ids);
}
