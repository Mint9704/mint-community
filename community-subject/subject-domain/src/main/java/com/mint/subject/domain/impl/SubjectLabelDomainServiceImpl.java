package com.mint.subject.domain.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.mint.subject.domain.SubjectLabelDomainService;
import com.mint.subject.entity.SubjectCategory;
import com.mint.subject.entity.SubjectLabel;
import com.mint.subject.entity.SubjectMapping;
import com.mint.subject.enums.CategoryTypeEnum;
import com.mint.subject.infra.basic.service.SubjectCategoryService;
import com.mint.subject.infra.basic.service.SubjectLabelService;
import com.mint.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/12
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Integer add(SubjectLabel subjectLabel) {
        return subjectLabelService.add(subjectLabel);
    }

    @Override
    public Integer update(SubjectLabel subjectLabel) {
        return subjectLabelService.update(subjectLabel);
    }

    @Override
    public Integer delete(Long id) {
        return subjectLabelService.delete(id);
    }

    @Override
    public List<SubjectLabel> queryLabelByCategoryId(Long categoryId) {
        SubjectCategory subjectCategory = subjectCategoryService.get(categoryId);
        if (CategoryTypeEnum.PRIMARY.getCode() == subjectCategory.getCategoryType()) {
            SubjectLabel subjectLabel = new SubjectLabel();
            return subjectLabelService.list(subjectLabel);
        }

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        List<Long> labelIdList = subjectMappingService.queryLabelIds(subjectMapping);
        if (CollectionUtils.isEmpty(labelIdList)) {
            return Collections.emptyList();
        }

        return subjectLabelService.queryByIds(labelIdList);
    }
}
