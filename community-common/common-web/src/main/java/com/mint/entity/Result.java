package com.mint.entity;

import com.mint.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Mint
 * @Create 2024/8/9
 */
@Data
public class Result<T> implements Serializable {
    public static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;

    public Result() {}

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultEnum.FAILURE.getCode(), ResultEnum.FAILURE.getMessage(), data);
    }

    public static <T> Result<T> fail() {
        return fail(null);
    }

}
