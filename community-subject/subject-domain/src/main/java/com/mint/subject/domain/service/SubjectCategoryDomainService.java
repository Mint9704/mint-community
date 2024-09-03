package com.mint.subject.domain.service;

import com.mint.subject.entity.SubjectCategory;

import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/10
 */
public interface SubjectCategoryDomainService {
    Boolean add(SubjectCategory subjectCategory);

    Boolean update(SubjectCategory subjectCategory);

    Boolean delete(Long id);

    List<SubjectCategory> list(SubjectCategory subjectCategory);
}
