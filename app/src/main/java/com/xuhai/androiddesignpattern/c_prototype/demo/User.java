package com.xuhai.androiddesignpattern.c_prototype.demo;

public class User implements Cloneable {

    public int age;

    public String name;

    public String phoneNum;

    public Address address;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        return user;
    }
}
