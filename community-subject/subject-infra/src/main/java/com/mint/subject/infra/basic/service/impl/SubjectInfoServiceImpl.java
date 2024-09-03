package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.infra.basic.mapper.SubjectInfoMapper;
import com.mint.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo> implements SubjectInfoService {
    @Override
    public IPage<SubjectInfo> list(SubjectInfo subjectInfo, long pageNum, long pageSize) {
        IPage<SubjectInfo> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
