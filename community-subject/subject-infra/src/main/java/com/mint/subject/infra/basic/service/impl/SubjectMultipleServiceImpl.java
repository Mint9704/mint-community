package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectMultiple;
import com.mint.subject.infra.basic.mapper.SubjectMultipleMapper;
import com.mint.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectMultipleServiceImpl extends ServiceImpl<SubjectMultipleMapper, SubjectMultiple> implements SubjectMultipleService {

    @Resource
    private SubjectMultipleMapper subjectMultipleMapper;

    @Override
    public int add(SubjectMultiple subjectMultiple) {
        return subjectMultipleMapper.insert(subjectMultiple);
    }

    @Override
    public int update(SubjectMultiple subjectMultiple) {
        return subjectMultipleMapper.updateById(subjectMultiple);
    }

    @Override
    public int delete(Long id) {
        return subjectMultipleMapper.deleteById(id);
    }

    @Override
    public SubjectMultiple get(Long id) {
        return subjectMultipleMapper.selectById(id);
    }

    @Override
    public IPage<SubjectMultiple> list(SubjectMultiple subjectMultiple, long pageNum, long pageSize) {
        IPage<SubjectMultiple> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
