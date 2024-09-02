package com.mint.subject.domain.handler;

import com.mint.subject.convert.SubjectInfoConverter;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.dto.SubjectOptionDTO;
import com.mint.subject.entity.SubjectRadio;
import com.mint.subject.enums.SubjectInfoTypeEnum;
import com.mint.subject.infra.basic.service.SubjectRadioService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/30
 * 单选题的策略
 */
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {
        List<SubjectOptionDTO> optionList = subjectInfoDTO.getOptions();
        List<SubjectRadio> radioList = SubjectInfoConverter.INSTANCE.convertOptionList2RadioList(optionList);
        radioList.forEach(l -> l.setSubjectId(subjectInfoDTO.getId()));
        subjectRadioService.saveBatch(radioList);
    }
}
