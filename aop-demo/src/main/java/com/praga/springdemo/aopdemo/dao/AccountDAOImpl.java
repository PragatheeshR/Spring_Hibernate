package com.praga.springdemo.aopdemo.dao;

import com.praga.springdemo.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String tech;

    AccountDAOImpl(){

    }


    @Override
    public void addAccount(Account account, int id, boolean isActive) {
        System.out.println("Adding new account info "+getClass());
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

    @Override
    public List<Account> findAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("Praga","Vellore"));
        accountList.add(new Account("Thani","Chennai"));
        accountList.add(new Account("Megala","Bangalore"));
        return accountList;
    }

    @Override
    public void findAccounts(boolean value) throws Exception {
        if(value){
            throw new Exception("Dummy Exception");
        }
    }

}
