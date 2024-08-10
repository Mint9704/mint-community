package com.mint.subject.domain.impl;

import com.mint.subject.domain.SubjectCategoryDomainService;
import com.mint.subject.entity.SubjectCategory;
import com.mint.subject.infra.basic.service.SubjectCategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/10
 */
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public Integer add(SubjectCategory subjectCategory) {
        return subjectCategoryService.add(subjectCategory);
    }

    @Override
    public Integer update(SubjectCategory subjectCategory) {
        return subjectCategoryService.update(subjectCategory);
    }

    @Override
    public Integer delete(Long id) {
        return subjectCategoryService.delete(id);
    }

    @Override
    public List<SubjectCategory> list(SubjectCategory subjectCategory) {
        return subjectCategoryService.list(subjectCategory);
    }
}
