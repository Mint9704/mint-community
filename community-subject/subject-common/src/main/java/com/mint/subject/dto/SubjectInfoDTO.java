package com.mint.subject.dto;

import com.mint.web.entity.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Author Mint
 * @Create 2024/8/26
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubjectInfoDTO extends BasePo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 是否正确
     */
    private Integer isCorrect;
    /**
     * 分类 id
     */
    private List<Long> categoryIds;
    /**
     * 标签 id
     */
    private List<Long> labelIds;
    /**
     * 选项
     */
    private List<SubjectOptionDTO> options;

    /**
     * 分类 id
     */
    private Long categoryId;

    /**
     * 标签 id
     */
    private Long labelId;

    /**
     * 分页查询，页数
     */
    private Integer pageNum;

    /**
     * 分页查询，每页数据条数
     */
    private Integer pageSize;
}
