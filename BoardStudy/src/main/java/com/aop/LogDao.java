package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class LogDao {

  @Around("execution(public * dao.*.*(..))")
  public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
    String signatureString = joinPoint.getSignature().toShortString();
    System.out.println(signatureString + "시작");
    long start = System.currentTimeMillis();
    try {
      Object result = joinPoint.proceed();
      return result;
    } finally {
      long finish = System.currentTimeMillis();
      System.out.println(signatureString + "종료");
      System.out.println(signatureString + "실행 시간:" + (finish - start) + "ms");
    }
  }
}
