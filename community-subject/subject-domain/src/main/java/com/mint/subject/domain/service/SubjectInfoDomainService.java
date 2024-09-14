package com.mint.subject.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.vo.SubjectInfoVO;

/**
 * @Author Mint
 * @Create 2024/8/30
 */
public interface SubjectInfoDomainService {
    void add(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoVO get(Long id);

    IPage<SubjectInfoVO> page(SubjectInfoDTO subjectInfoDTO);
}
