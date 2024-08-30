package com.mint.subject.domain.handler;

import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.enums.SubjectInfoTypeEnum;

/**
 * @Author Mint
 * @Create 2024/8/30
 */
public interface SubjectTypeHandler {
    SubjectInfoTypeEnum getHandlerType();

    void add(SubjectInfoDTO subjectInfoDTO);
}
