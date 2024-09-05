package com.mint.subject.infra.basic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mint.subject.entity.SubjectInfo;

import java.util.List;

public interface SubjectInfoService extends IService<SubjectInfo> {
    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, Integer start, Integer pageSize);
}
