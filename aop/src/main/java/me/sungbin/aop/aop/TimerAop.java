package me.sungbin.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* me.sungbin.aop.controller..*.*(..))")
    private void cut() {

    }

    @Pointcut("@annotation(me.sungbin.aop.annotation.Timer)")
    private void enableTimer() {

    }

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = pjp.proceed();

        stopWatch.stop();

        System.out.println("total time: " + stopWatch.getTotalTimeSeconds());
    }
}
