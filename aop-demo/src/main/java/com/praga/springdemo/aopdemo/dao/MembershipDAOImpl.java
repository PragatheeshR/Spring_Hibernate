package com.praga.springdemo.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    MembershipDAOImpl(){
        System.out.println("inside cont");
    }

    @Override
    public void addAccount() {
        System.out.println("Adding account in DB "+getClass());
    }
}
