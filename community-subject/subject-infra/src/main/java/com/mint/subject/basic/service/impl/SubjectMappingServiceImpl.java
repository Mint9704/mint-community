package com.mint.subject.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectMapping;
import com.mint.subject.basic.mapper.SubjectMappingMapper;
import com.mint.subject.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping> implements SubjectMappingService {

    @Resource
    private SubjectMappingMapper subjectMappingMapper;

    @Override
    public int add(SubjectMapping subjectMapping) {
        return subjectMappingMapper.insert(subjectMapping);
    }

    @Override
    public int update(SubjectMapping subjectMapping) {
        return subjectMappingMapper.updateById(subjectMapping);
    }

    @Override
    public int delete(Long id) {
        return subjectMappingMapper.deleteById(id);
    }

    @Override
    public SubjectMapping get(Long id) {
        return subjectMappingMapper.selectById(id);
    }
}
