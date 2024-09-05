package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.infra.basic.mapper.SubjectInfoMapper;
import com.mint.subject.infra.basic.service.SubjectInfoService;
import com.mint.web.enums.IsDeletedEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo> implements SubjectInfoService {

    @Resource
    private SubjectInfoMapper subjectInfoMapper;

    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, Integer start, Integer pageSize) {
        return subjectInfoMapper.queryPage(subjectInfo, categoryId, labelId, start, pageSize);
    }
}
