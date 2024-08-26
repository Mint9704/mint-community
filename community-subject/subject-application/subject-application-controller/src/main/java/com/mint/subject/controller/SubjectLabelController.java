package com.mint.subject.controller;

import com.mint.web.entity.Result;
import com.mint.subject.domain.SubjectLabelDomainService;
import com.mint.subject.entity.SubjectLabel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/12
 */
@RestController
@RequestMapping("/subject/label")
public class SubjectLabelController {
    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    @PostMapping("/add")
    public Result<Integer> add(@RequestBody SubjectLabel subjectLabel) {
        return Result.success(subjectLabelDomainService.add(subjectLabel));
    }

    @PutMapping("/update")
    public Result<Integer> update(@RequestBody SubjectLabel subjectLabel) {
        return Result.success(subjectLabelDomainService.update(subjectLabel));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> delete(@PathVariable("id") Long id) {
        return Result.success(subjectLabelDomainService.delete(id));
    }

    @GetMapping("/get/{categoryId}")
    public Result<List<SubjectLabel>> queryByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return Result.success(subjectLabelDomainService.queryLabelByCategoryId(categoryId));
    }
}
