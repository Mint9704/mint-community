package com.mint.subject.domain;

import com.mint.subject.entity.SubjectCategory;

import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/10
 */
public interface SubjectCategoryDomainService {
    Integer add(SubjectCategory subjectCategory);

    Integer update(SubjectCategory subjectCategory);

    Integer delete(Long id);

    List<SubjectCategory> list(SubjectCategory subjectCategory);
}
