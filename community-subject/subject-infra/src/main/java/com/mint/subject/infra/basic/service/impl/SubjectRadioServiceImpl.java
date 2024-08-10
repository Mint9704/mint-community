package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectRadio;
import com.mint.subject.infra.basic.mapper.SubjectRadioMapper;
import com.mint.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioMapper, SubjectRadio> implements SubjectRadioService {

    @Resource
    private SubjectRadioMapper subjectRadioMapper;

    @Override
    public int add(SubjectRadio subjectRadio) {
        return subjectRadioMapper.insert(subjectRadio);
    }

    @Override
    public int update(SubjectRadio subjectRadio) {
        return subjectRadioMapper.updateById(subjectRadio);
    }

    @Override
    public int delete(Long id) {
        return subjectRadioMapper.deleteById(id);
    }

    @Override
    public SubjectRadio get(Long id) {
        return subjectRadioMapper.selectById(id);
    }

    @Override
    public IPage<SubjectRadio> list(SubjectRadio subjectRadio, long pageNum, long pageSize) {
        IPage<SubjectRadio> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
