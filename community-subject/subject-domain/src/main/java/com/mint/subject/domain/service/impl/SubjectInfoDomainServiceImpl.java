package com.mint.subject.domain.service.impl;

import com.mint.subject.convert.SubjectInfoConverter;
import com.mint.subject.domain.service.SubjectInfoDomainService;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Mint
 * @Create 2024/8/30
 */
@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {
    @Resource
    private SubjectInfoService subjectInfoService;

    @Override
    public void add(SubjectInfoDTO subjectInfoDTO) {
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertSubjectInfoDTO2SubjectInfo(subjectInfoDTO);
        subjectInfoService.add(subjectInfo);
    }
}
