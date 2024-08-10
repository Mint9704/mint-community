package com.mint.subject.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectBrief;
import com.mint.subject.basic.mapper.SubjectBriefMapper;
import com.mint.subject.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief> implements SubjectBriefService {

    @Resource
    private SubjectBriefMapper subjectBriefMapper;

    @Override
    public int add(SubjectBrief subjectBrief) {
        return subjectBriefMapper.insert(subjectBrief);
    }

    @Override
    public int update(SubjectBrief subjectBrief) {
        return subjectBriefMapper.updateById(subjectBrief);
    }

    @Override
    public int delete(Long id) {
        return subjectBriefMapper.deleteById(id);
    }

    @Override
    public SubjectBrief get(Long id) {
        return subjectBriefMapper.selectById(id);
    }

    @Override
    public IPage<SubjectBrief> list(SubjectBrief subjectBrief, long pageNum, long pageSize) {
        IPage<SubjectBrief> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
