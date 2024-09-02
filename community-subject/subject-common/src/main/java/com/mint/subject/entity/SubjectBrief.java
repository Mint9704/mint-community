package com.mint.subject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mint.web.entity.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 简答题
 */
@TableName("subject_brief")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubjectBrief extends BasePo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 题目答案
     */
    private String subjectAnswer;
}

