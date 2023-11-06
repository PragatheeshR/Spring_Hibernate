package com.praga.springdemo.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class AnalyticsAspect {

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.addAccount())")
    private void commonPointCut(){}

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.get*())")
    private void aspectForGetter(){}

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.set*(..))")
    private void aspectForSetter(){}

    @Pointcut("commonPointCut() && !(aspectForGetter() || aspectForSetter())")
    private void allInOne(){}

    @Before("allInOne()")
    public void dePerform(){
        System.out.println("Doing performing analysis");
    }
}
