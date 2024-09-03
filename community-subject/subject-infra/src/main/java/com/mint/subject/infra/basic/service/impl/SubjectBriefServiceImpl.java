package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectBrief;
import com.mint.subject.infra.basic.mapper.SubjectBriefMapper;
import com.mint.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief> implements SubjectBriefService {
    @Override
    public IPage<SubjectBrief> list(SubjectBrief subjectBrief, long pageNum, long pageSize) {
        IPage<SubjectBrief> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
