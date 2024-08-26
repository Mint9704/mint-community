package com.mint.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Mint
 * @Create 2024/8/26
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubjectOptionDTO {
    /**
     * 类型
     */
    private Long optionType;

    /**
     * 内容
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;
}
