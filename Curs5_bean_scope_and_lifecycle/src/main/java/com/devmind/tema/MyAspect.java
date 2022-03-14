package com.devmind.tema;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* run (..))")
    private void run() {}

    @After(value = "run()", argNames = "joinPoint")
    public void afterCall(JoinPoint joinPoint) {
        System.out.println("Aspect called");
    }
}
