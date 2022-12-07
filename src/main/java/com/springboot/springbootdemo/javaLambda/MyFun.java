package com.springboot.springbootdemo.javaLambda;

@FunctionalInterface
public interface MyFun<T> {
    public Integer getValue(T t);
}
