package com.mint.subject.domain.handler;

import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.enums.SubjectInfoTypeEnum;

/**
 * @Author Mint
 * @Create 2024/8/30
 * 简答题的策略
 */
public class BriefTypeHandler implements SubjectTypeHandler{
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {

    }
}
