package com.mint.subject.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.basic.entity.SubjectInfo;
import com.mint.subject.basic.mapper.SubjectInfoMapper;
import com.mint.subject.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Mint
 * @Create 2024/8/1
 */
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo> implements SubjectInfoService {

    @Resource
    private SubjectInfoMapper subjectInfoMapper;

    @Override
    public int add(SubjectInfo subjectInfo) {
        return subjectInfoMapper.insert(subjectInfo);
    }

    @Override
    public int update(SubjectInfo subjectInfo) {
        return subjectInfoMapper.updateById(subjectInfo);
    }

    @Override
    public int delete(Long id) {
        return subjectInfoMapper.deleteById(id);
    }

    @Override
    public SubjectInfo get(Long id) {
        return subjectInfoMapper.selectById(id);
    }

    @Override
    public IPage<SubjectInfo> list(SubjectInfo subjectInfo, long pageNum, long pageSize) {
        IPage<SubjectInfo> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
