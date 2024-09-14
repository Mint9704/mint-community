package com.mint.subject.convert;

import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.dto.SubjectOptionDTO;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.entity.SubjectMultiple;
import com.mint.subject.entity.SubjectRadio;
import com.mint.subject.vo.SubjectInfoVO;
import com.mint.subject.vo.SubjectOptionVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/26
 */
@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertSubjectInfoDTO2SubjectInfo(SubjectInfoDTO subjectInfoDTO);

    List<SubjectRadio> convertOptionList2RadioList(List<SubjectOptionDTO> optionList);

    List<SubjectMultiple> convertOptionList2MultipleList(List<SubjectOptionDTO> optionList);

    SubjectInfoVO convertSubjectInfo2SubjectInfoVO(SubjectInfo subjectInfo);

    List<SubjectInfoVO> convertSubjectInfoList2VoList(List<SubjectInfo> subjectInfoList);

    List<SubjectOptionVO> convertMultipleList2OptionVOList(List<SubjectMultiple> multipleList);

    List<SubjectOptionVO> convertRadioList2OptionVOList(List<SubjectRadio> radioList);
}
