package com.mint.web.enums;

import lombok.Getter;

/**
 * @Author Mint
 * @Create 2024/8/12
 */
@Getter
public enum IsDeletedEnum {
    DELETED(1,"已删除"),
    UN_DELETED(0,"未删除");

    public int code;

    public String desc;

    IsDeletedEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedEnum getByCode(int codeVal){
        for(IsDeletedEnum resultCodeEnum : IsDeletedEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
