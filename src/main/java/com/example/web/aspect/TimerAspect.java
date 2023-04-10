package com.example.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Around("execution(* com.example.web.*.*.*(..))")
  public Object longTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long executionTime = System.currentTimeMillis() - start;
    logger.info("execution-time:{}", executionTime);
    return proceed;
  }
}
