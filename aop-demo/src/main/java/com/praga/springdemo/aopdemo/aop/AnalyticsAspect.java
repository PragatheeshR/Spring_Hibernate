package com.praga.springdemo.aopdemo.aop;

import com.praga.springdemo.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Order(2)
public class AnalyticsAspect {

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.findAccounts(..))")
    private void commonPointCut(){}

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.get*())")
    private void aspectForGetter(){}

    @Pointcut("execution(* com.praga.springdemo.aopdemo.dao.*.set*(..))")
    private void aspectForSetter(){}

    @Pointcut("commonPointCut() && !(aspectForGetter() || aspectForSetter())")
    private void allInOne(){}

    @Before("allInOne()")
    public void dePerform(JoinPoint joinPoint){ //JoinPoint - can be used to get the method signature to get details from it

        System.out.println("Doing performing analysis");
        System.out.println(joinPoint.getSignature());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "allInOne()", returning = "result")
    public void afterPerform(JoinPoint joinPoint, List<Account> result){
        System.out.println("========================");
        System.out.println("Currently in After Return");
        System.out.println(result);
        System.out.println("Updating the data");
        if(result != null && !result.isEmpty()){
            result.get(0).setName("rajam");
        }
        //System.out.println(result);
        //System.out.println(Arrays.toString(joinPoint));
        System.out.println("========================");

    }


    @AfterThrowing(pointcut = "allInOne()", throwing = "throwable")
    public void afterthrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("Inside the AfterThrowing section "+throwable.getMessage());
    }
}
