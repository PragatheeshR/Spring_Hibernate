package com.praga.springdemo.aopdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(8) // to say in which order aspect has to be called
public class AccountAOP {



    @Around("execution(* com.praga.springdemo.aopdemo.service.*.getInfo(..))")
    public Object getFortuneInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        System.out.println(proceedingJoinPoint.getSignature());

        long begin = System.currentTimeMillis();

        String object =  null;

        try {
            object= (String) proceedingJoinPoint.proceed();
        }
        catch(RuntimeException exception){
            System.out.println(exception.getMessage());
            object = "Major Accident but you ar safe... Private JET on the way";
            throw  exception;
        }

        long end = System.currentTimeMillis();

        System.out.println("Total Time taken  "+ (end - begin) / 1000.0);

        return object;
    }

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.addAccount())")
    private void commonPointCut(){}

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.get*())")
    private void aspectForGetter(){}

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.set*(..))")
    private void aspectForSetter(){}

    @Pointcut("commonPointCut() && !(aspectForGetter() || aspectForSetter())")
    private void allInOne(){}








    //@Before("execution(void addAccount())")
    @Before("allInOne()") // we can use * to mention experssion
    //to call only specific class, use package name
    public void doAscpect(){
        System.out.println("Ascpect completed");
    }





}
