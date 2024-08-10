package com.mint.subject.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectCategory;
import com.mint.subject.basic.mapper.SubjectCategoryMapper;
import com.mint.subject.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory> implements SubjectCategoryService {

    @Resource
    private SubjectCategoryMapper subjectCategoryMapper;

    @Override
    public int add(SubjectCategory subjectCategory) {
        return subjectCategoryMapper.insert(subjectCategory);
    }

    @Override
    public int update(SubjectCategory subjectCategory) {
        return subjectCategoryMapper.updateById(subjectCategory);
    }

    @Override
    public int delete(Long id) {
        return subjectCategoryMapper.deleteById(id);
    }

    @Override
    public SubjectCategory get(Long id) {
        return subjectCategoryMapper.selectById(id);
    }

    @Override
    public IPage<SubjectCategory> list(SubjectCategory SubjectCategory, long pageNum, long pageSize) {
        IPage<SubjectCategory> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
