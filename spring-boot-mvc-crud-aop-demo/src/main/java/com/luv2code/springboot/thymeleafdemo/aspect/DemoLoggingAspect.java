package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class DemoLoggingAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void commonAspect(){

    }

    @Before("commonAspect()")
    public void before(JoinPoint joinPoint){

        String calling = joinPoint.getSignature().toShortString();

        logger.info("@Before Calling method ==> "+calling);

        //getting arguments from calling method
        Object[] args = joinPoint.getArgs();

        for(Object object : args){
            logger.info("Args ==> "+object);
        }


    }

    @AfterReturning(pointcut = "commonAspect()",
                    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String calling = joinPoint.getSignature().toShortString();

        logger.info("@AfterReturning Calling method ==> "+calling);

        logger.info("output "+result);
    }
}
