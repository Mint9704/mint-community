package com.mint.subject.domain.service;

import com.mint.subject.entity.SubjectLabel;

import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/12
 */
public interface SubjectLabelDomainService {
    Boolean add(SubjectLabel subjectLabel);

    Boolean update(SubjectLabel subjectLabel);

    Boolean delete(Long id);

    List<SubjectLabel> queryLabelByCategoryId(Long categoryId);
}
