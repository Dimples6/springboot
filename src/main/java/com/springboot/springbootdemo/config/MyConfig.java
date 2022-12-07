package com.springboot.springbootdemo.config;


import com.springboot.springbootdemo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类里面是有@Bean注解标注在方法上给容器注册主键，默认也是单实例的（单例）
 * 2.配置类本事也是一个组件
 * 3.proxyBeanMethods:代理bean的方法
 *       Full（proxyBeanMethods = true）
 *       Lite（proxyBeanMethods = false）
 *       组件依赖
 * 4.@Import(User.class)  这个注解在哪里都可以使用
 *    给容器中自动创建出组件、默认组件的名字就是全类名
 *
 */
@Import(User.class)
@Configuration(proxyBeanMethods = true)   //告诉SpringBoot这是一个配置类  == 配置文件
public class MyConfig {


    /**
     * 外部无论对配置类中这个主键注册方法调用多少次读取的都是容器中注册的单实例对象
     * @return
     */
    @Bean //给容器中添加主键。  以方法名作为主键的id。  返回类型就是主键类型  返回值就是主键在容器中的实例
    public User myUser(){
        return new User("zhangshan",12);
    }
}
