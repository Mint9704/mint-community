package com.mint.subject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mint.entity.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 判断题
 */
@TableName("subject_judge")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubjectJudge extends BasePo {
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
     * 是否正确
     */
    private Integer isCorrect;
}

