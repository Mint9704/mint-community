package com.mint.subject.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectLabel;
import com.mint.subject.basic.mapper.SubjectLabelMapper;
import com.mint.subject.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel> implements SubjectLabelService {

    @Resource
    private SubjectLabelMapper subjectLabelMapper;

    @Override
    public int add(SubjectLabel subjectLabel) {
        return subjectLabelMapper.insert(subjectLabel);
    }

    @Override
    public int update(SubjectLabel subjectLabel) {
        return subjectLabelMapper.updateById(subjectLabel);
    }

    @Override
    public int delete(Long id) {
        return subjectLabelMapper.deleteById(id);
    }

    @Override
    public SubjectLabel get(Long id) {
        return subjectLabelMapper.selectById(id);
    }

    @Override
    public IPage<SubjectLabel> list(SubjectLabel subjectLabel, long pageNum, long pageSize) {
        IPage<SubjectLabel> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
