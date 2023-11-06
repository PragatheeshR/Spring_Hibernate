package com.praga.springdemo.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String tech;

    AccountDAOImpl(){
        System.out.println("inside cont");
    }

    @Override
    public void addAccount() {
        System.out.println("Adding account in DB "+getClass());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
