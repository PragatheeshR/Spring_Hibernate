package com.praga.springdemo.aopdemo.dao;

import com.praga.springdemo.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, int id, boolean isActive);

    public String getName() ;

    public void setName(String name) ;

    public String getTech() ;

    public void setTech(String tech);

    public List<Account> findAccounts();

    public void findAccounts(boolean value) throws Exception;
}
