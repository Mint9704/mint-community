package com.mint.subject.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mint.web.entity.Result;
import com.mint.subject.entity.SubjectInfo;
import com.mint.subject.infra.basic.service.SubjectInfoService;
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
    private SubjectInfoService subjectInfoService;

    @PostMapping("/add")
    public Result<Integer> addSubject(@RequestBody SubjectInfo subjectInfo) {
        return Result.success(subjectInfoService.add(subjectInfo));
    }

    @PutMapping("/update")
    public Result<Integer> updateSubject(@RequestBody SubjectInfo subjectInfo) {
        return Result.success(subjectInfoService.update(subjectInfo));
    }

    @GetMapping("/get/{id}")
    public Result<SubjectInfo> getSubject(@PathVariable Long id) {
        return Result.success(subjectInfoService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> deleteSubject(@PathVariable Long id) {
        return Result.success(subjectInfoService.delete(id));
    }

    @PostMapping("/page")
    public Result<IPage<SubjectInfo>> listSubject(@RequestBody SubjectInfo subjectInfo, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return Result.success(subjectInfoService.list(subjectInfo, pageNum, pageSize));
    }

}
