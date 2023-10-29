package com.praga.springlearn.SpringMVC.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String country;

    private String favProgramLang;

    private List<String> favOS;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Student(String firstName, String lastName, int age, String favProgramLang) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favProgramLang = favProgramLang;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavProgramLang() {
        return favProgramLang;
    }

    public void setFavProgramLang(String favProgramLang) {
        this.favProgramLang = favProgramLang;
    }

    public List<String> getFavOS() {
        return favOS;
    }

    public void setFavOS(List<String> favOS) {
        this.favOS = favOS;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

}
