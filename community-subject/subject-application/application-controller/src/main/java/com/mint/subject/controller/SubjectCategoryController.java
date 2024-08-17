package com.mint.subject.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.mint.web.entity.Result;
import com.mint.subject.domain.SubjectCategoryDomainService;
import com.mint.subject.entity.SubjectCategory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/10
 */
@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Integer> add(@RequestBody SubjectCategory subjectCategory) {
        Preconditions.checkNotNull(subjectCategory.getCategoryType(), "分类类型不可为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(subjectCategory.getCategoryName()), "分类名称不可为空");
        return Result.success(subjectCategoryDomainService.add(subjectCategory));
    }

    @PutMapping("/update")
    public Result<Integer> update(@RequestBody SubjectCategory subjectCategory) {
        return Result.success(subjectCategoryDomainService.update(subjectCategory));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.success(subjectCategoryDomainService.delete(id));
    }

    @GetMapping("/list")
    public Result<List<SubjectCategory>> list(@RequestBody SubjectCategory subjectCategory) {
        return Result.success(subjectCategoryDomainService.list(subjectCategory));
    }
}
