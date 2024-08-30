package com.mint.subject.domain.handler;

import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.enums.SubjectInfoTypeEnum;

/**
 * @Author Mint
 * @Create 2024/8/30
 * 判断题的策略
 */
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {

    }
}
