package com.mint.handler;

import com.mint.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Mint
 * @Create 2024/8/12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public Result runTimeExceptionHandler(RuntimeException exception) {
        log.error("RuntimeException: {}", exception);
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Result exceptionHandler(Exception exception) {
        log.error("Exception: {}", exception);
        return Result.fail(exception.getMessage());
    }
}
