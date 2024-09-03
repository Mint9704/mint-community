package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectJudge;
import com.mint.subject.infra.basic.mapper.SubjectJudgeMapper;
import com.mint.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeMapper, SubjectJudge> implements SubjectJudgeService {
    @Override
    public IPage<SubjectJudge> list(SubjectJudge subjectJudge, long pageNum, long pageSize) {
        IPage<SubjectJudge> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
