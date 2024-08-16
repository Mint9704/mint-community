package com.mint.log.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Author Mint
 * @Create 2024/8/16
 */
@Aspect
@Slf4j
@Component
@ConditionalOnProperty(name = {"log.aspect.enable"}, havingValue = "true", matchIfMissing = true)
public class LogAspect {
    @Pointcut("execution(* com.mint.*.controller.*Controller.*(..)) || execution(* com.mint.*.service.*Service.*(..))")
    private void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] reqArgs = pjp.getArgs();
        String req = JSON.toJSONString(reqArgs);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String methodName = methodSignature.getDeclaringType().getName() + "." + methodSignature.getName();
        log.info("{},request:{}", methodName, req);
        Long startTime = System.currentTimeMillis();
        Object responseObj = pjp.proceed();
        String resp = JSON.toJSONString(responseObj);
        Long endTime = System.currentTimeMillis();
        log.info("{},response:{},costTime:{}", methodName, resp, endTime - startTime);
        return responseObj;
    }
}
