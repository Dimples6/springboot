package com.springboot.springbootdemo.javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda表达式
 * 左边参数列表
 * 右边方法体
 *
 * Lambda需要“函数式接口”的支持
 * 函数式接口：只有一个抽象方法的接口叫做函数式接口,可以使用注解@FunctionalInterface 修饰，可以检查是否是函数式接口
 */
public class Test {
    public static void test1(){
        int num = 1;
        Runnable hello = () -> System.out.println("hello"+num);
        hello.run();
    }

    public static  void test2(){
        Consumer<String> com = x -> System.out.println(x);
        com.accept("小样");
    }

    public static void test3(){
        Comparator<Integer> com = (a,b) -> {
            System.out.println("你好");
            return Integer.compare(a,b);
        };
        com.compare(2,1);
    }

    public static void test4(){
        Integer value = getValue(50, (x) -> (Integer) x*(Integer) x);
        System.out.println(value);
    };

    public static  void test5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
    }

    public static Integer  getValue(int num, MyFun myFun){
        return myFun.getValue(num);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
