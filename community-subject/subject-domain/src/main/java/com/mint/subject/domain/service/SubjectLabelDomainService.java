package com.mint.subject.domain.service;

import com.mint.subject.entity.SubjectLabel;

import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/12
 */
public interface SubjectLabelDomainService {
    Integer add(SubjectLabel subjectLabel);

    Integer update(SubjectLabel subjectLabel);

    Integer delete(Long id);

    List<SubjectLabel> queryLabelByCategoryId(Long categoryId);
}
