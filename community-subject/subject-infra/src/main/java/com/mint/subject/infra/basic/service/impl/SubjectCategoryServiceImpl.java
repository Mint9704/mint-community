package com.mint.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mint.enums.IsDeletedEnum;
import com.mint.subject.entity.SubjectCategory;
import com.mint.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.mint.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<SubjectCategory> list(SubjectCategory subjectCategory) {
        QueryWrapper<SubjectCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", IsDeletedEnum.UN_DELETED.getCode());
        if (subjectCategory.getId() != null) {
            queryWrapper.eq("id", subjectCategory.getId());
        }
        if (StringUtils.isNotBlank(subjectCategory.getCategoryName())) {
            queryWrapper.eq("category_name", subjectCategory.getCategoryName());
        }
        if (subjectCategory.getCategoryType() != null) {
            queryWrapper.eq("category_type", subjectCategory.getCategoryType());
        }
        if (StringUtils.isNotBlank(subjectCategory.getImageUrl())) {
            queryWrapper.eq("image_url", subjectCategory.getImageUrl());
        }
        if (subjectCategory.getParentId() != null) {
            queryWrapper.eq("parent_id", subjectCategory.getParentId());
        }
        if (StringUtils.isNotBlank(subjectCategory.getCreatedBy())) {
            queryWrapper.eq("created_by", subjectCategory.getCreatedBy());
        }

        return subjectCategoryMapper.selectList(queryWrapper);
    }
}
