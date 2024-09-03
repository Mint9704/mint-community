package com.mint.subject.domain.service.impl;

import com.mint.subject.domain.service.SubjectCategoryDomainService;
import com.mint.subject.entity.SubjectCategory;
import com.mint.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/10
 */
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public Boolean add(SubjectCategory subjectCategory) {
        return subjectCategoryService.save(subjectCategory);
    }

    @Override
    public Boolean update(SubjectCategory subjectCategory) {
        return subjectCategoryService.updateById(subjectCategory);
    }

    @Override
    public Boolean delete(Long id) {
        return subjectCategoryService.removeById(id);
    }

    @Override
    public List<SubjectCategory> list(SubjectCategory subjectCategory) {
        return subjectCategoryService.list(subjectCategory);
    }
}
