package com.mint.subject.domain.handler;

import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectJudge;
import com.mint.subject.enums.SubjectInfoTypeEnum;
import com.mint.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Mint
 * @Create 2024/8/30
 * 判断题的策略
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {
        SubjectJudge judge = new SubjectJudge();
        judge.setSubjectId(subjectInfoDTO.getId());
        judge.setIsCorrect(subjectInfoDTO.getIsCorrect());
        subjectJudgeService.save(judge);
    }
}
