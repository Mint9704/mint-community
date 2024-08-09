package com.mint.enums;

/**
 * @Author Mint
 * @Create 2024/8/9
 */
public enum ResultEnum {
    SUCCESS(200, "Success"),
    FAILURE(500, "Failure");

    private final int code;
    private final String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
