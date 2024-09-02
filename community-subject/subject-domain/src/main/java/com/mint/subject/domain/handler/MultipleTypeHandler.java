package com.mint.subject.domain.handler;

import com.mint.subject.convert.SubjectInfoConverter;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.dto.SubjectOptionDTO;
import com.mint.subject.entity.SubjectMultiple;
import com.mint.subject.enums.SubjectInfoTypeEnum;
import com.mint.subject.infra.basic.service.SubjectMultipleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/30
 * 多选题的策略
 */
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {
        List<SubjectOptionDTO> optionList = subjectInfoDTO.getOptions();
        List<SubjectMultiple> multipleList = SubjectInfoConverter.INSTANCE.convertOptionList2MultipleList(optionList);
        multipleList.forEach(l -> l.setSubjectId(subjectInfoDTO.getId()));
        subjectMultipleService.saveBatch(multipleList);
    }
}
