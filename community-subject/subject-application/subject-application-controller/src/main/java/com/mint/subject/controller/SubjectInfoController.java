package com.mint.subject.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.mint.subject.domain.service.SubjectInfoDomainService;
import com.mint.subject.dto.SubjectInfoDTO;
import com.mint.subject.vo.SubjectInfoVO;
import com.mint.web.entity.Result;
import com.mint.subject.entity.SubjectInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Mint
 * @Create 2024/7/31
 */
@RestController
@RequestMapping("/subject/info")
public class SubjectInfoController {
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    @PostMapping("/add")
    public Result<Integer> addSubject(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        Preconditions.checkArgument(StringUtils.isNotBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
        Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
        Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
        Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(subjectInfoDTO.getCategoryIds()), "题目分类不能为空");
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(subjectInfoDTO.getLabelIds()), "题目标签不能为空");

        subjectInfoDomainService.add(subjectInfoDTO);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<SubjectInfoVO> getSubject(@PathVariable Long id) {
        return Result.success(subjectInfoDomainService.get(id));
    }

    @PostMapping("/page")
    public Result<IPage<SubjectInfoVO>> listSubject(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
        Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");
        return Result.success(subjectInfoDomainService.page(subjectInfoDTO));
    }

}
