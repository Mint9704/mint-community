package com.mint.subject.convert;

import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Mint
 * @Create 2024/8/26
 */
@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertSubjectInfoDTO2SubjectInfo(SubjectInfoDTO subjectInfoDTO);

}
