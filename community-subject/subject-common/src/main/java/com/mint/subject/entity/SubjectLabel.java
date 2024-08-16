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
 * 题目标签表
 */
@TableName("subject_Label")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubjectLabel extends BasePo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 分类 id
     */
    private Long categoryId;
    /**
     * 排序
     */
    private Integer sortNum;
}

