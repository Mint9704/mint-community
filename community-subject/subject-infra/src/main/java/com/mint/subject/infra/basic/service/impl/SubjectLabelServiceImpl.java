package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.web.enums.IsDeletedEnum;
import com.mint.subject.entity.SubjectLabel;
import com.mint.subject.infra.basic.mapper.SubjectLabelMapper;
import com.mint.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<SubjectLabel> list(SubjectLabel subjectLabel) {
        QueryWrapper<SubjectLabel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", IsDeletedEnum.UN_DELETED.getCode());
        if (subjectLabel.getId() != null) {
            queryWrapper.eq("id", subjectLabel.getId());
        }
        if (StringUtils.isNotBlank(subjectLabel.getLabelName())) {
            queryWrapper.eq("label_name", subjectLabel.getLabelName());
        }
        if (subjectLabel.getCategoryId() != null) {
            queryWrapper.eq("category_id", subjectLabel.getCategoryId());
        }
        return subjectLabelMapper.selectList(queryWrapper);
    }

    @Override
    public List<SubjectLabel> queryByIds(List<Long> ids) {
        QueryWrapper<SubjectLabel> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids);
        return subjectLabelMapper.selectList(queryWrapper);
    }
}
