package com.mint.subject.domain.handler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectBrief;
import com.mint.subject.enums.SubjectInfoTypeEnum;
import com.mint.subject.infra.basic.service.SubjectBriefService;
import com.mint.subject.vo.SubjectInfoVO;
import com.mint.web.enums.IsDeletedEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Mint
 * @Create 2024/8/30
 * 简答题的策略
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {
        SubjectBrief brief = new SubjectBrief();
        brief.setSubjectId(subjectInfoDTO.getId());
        brief.setSubjectAnswer(subjectInfoDTO.getSubjectAnswer());
        subjectBriefService.save(brief);
    }

    @Override
    public SubjectInfoVO get(SubjectInfoVO subjectInfoVO) {
        QueryWrapper<SubjectBrief> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject_id", subjectInfoVO.getId());
        queryWrapper.eq("is_deleted", IsDeletedEnum.UN_DELETED.getCode());
        SubjectBrief brief = subjectBriefService.getOne(queryWrapper);
        subjectInfoVO.setSubjectAnswer(brief.getSubjectAnswer());
        return subjectInfoVO;
    }
}
