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

    @Resource
    private SubjectJudgeMapper subjectJudgeMapper;

    @Override
    public int add(SubjectJudge subjectJudge) {
        return subjectJudgeMapper.insert(subjectJudge);
    }

    @Override
    public int update(SubjectJudge subjectJudge) {
        return subjectJudgeMapper.updateById(subjectJudge);
    }

    @Override
    public int delete(Long id) {
        return subjectJudgeMapper.deleteById(id);
    }

    @Override
    public SubjectJudge get(Long id) {
        return subjectJudgeMapper.selectById(id);
    }

    @Override
    public IPage<SubjectJudge> list(SubjectJudge subjectJudge, long pageNum, long pageSize) {
        IPage<SubjectJudge> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
