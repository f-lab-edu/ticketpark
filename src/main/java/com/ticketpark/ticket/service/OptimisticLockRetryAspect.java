package com.ticketpark.ticket.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class OptimisticLockRetryAspect {

    @Value("${retry.optimisticLock.count}")
    private byte retryCount;

    @Around("@annotation(retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint, OptimisticLockRetry retry) throws Throwable {
        RuntimeException exceptionHolder = null;
        int maxRetry = retryCount > 0 ? retryCount : retry.value();

        for (int retryIndex = 1; retryIndex <= maxRetry; retryIndex++) {
            try {
                log.debug("[retry] try count {}/{}", retryIndex, maxRetry);
                return joinPoint.proceed();
            } catch (OptimisticLockingFailureException e) {
                log.debug("버전 충돌 발생 / 예매 retry start {}", joinPoint.getArgs());
                exceptionHolder = e;
            }
        }
        throw exceptionHolder;
    }
}
