package com.praga.springdemo.aopdemo.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {

    private String name;
    private String address;

    public Account() {
    }

    public Account(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
