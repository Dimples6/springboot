package com.springboot.springbootdemo.bean;

/**
 * 人员
 */
public class User {
    public String name;
    public int age;

    public User() {
    }

    public User(String name, int age) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
