package com.mint.subject.vo;

import com.mint.web.entity.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Mint
 * @Create 2024/9/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOptionVO extends BasePo {
    /**
     * a,b,c,d
     */
    private Long optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
}
