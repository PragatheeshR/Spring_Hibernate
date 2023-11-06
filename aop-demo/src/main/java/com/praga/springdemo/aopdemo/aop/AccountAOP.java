package com.praga.springdemo.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(8)
public class AccountAOP {

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
