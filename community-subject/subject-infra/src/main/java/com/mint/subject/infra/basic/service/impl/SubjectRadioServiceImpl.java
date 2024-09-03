package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.subject.entity.SubjectRadio;
import com.mint.subject.infra.basic.mapper.SubjectRadioMapper;
import com.mint.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioMapper, SubjectRadio> implements SubjectRadioService {
    @Override
    public IPage<SubjectRadio> list(SubjectRadio subjectRadio, long pageNum, long pageSize) {
        IPage<SubjectRadio> page = page(new Page<>(pageNum, pageSize));
        return this.page(page, null);
    }
}
