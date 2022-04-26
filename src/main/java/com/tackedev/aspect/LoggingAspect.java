package com.tackedev.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.tackedev.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.tackedev.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.tackedev.repository.*.*(..))")
    private void forRepositoryPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("===>> in @Before: calling method {}", methodName);
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("===>> in @AfterReturning: calling method {}", methodName);
        logger.info("===>> result: {}", result);
    }
}
