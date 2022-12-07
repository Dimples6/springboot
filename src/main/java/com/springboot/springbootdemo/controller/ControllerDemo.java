package com.springboot.springbootdemo.controller;

import com.springboot.springbootdemo.bean.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerDemo {

    //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

    @RequestMapping("/test")
    public String springBootTest(){
        return "Hello springBoot";
    }

    //form表单进行get请求的时候会访问到这里(获取用户)可以直接换为@getmapping注解
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-zhangsan";
    }

    //form表单进行post请求的时候会访问到这里（保存用户）可以直接换为@postmapping注解
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String postUser(){
        return "POST-zhangsan";
    }

    //form表单进行delete请求的时候会访问到这里（删除用户）可以直接换为@deletemapping注解
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-zhangsan";
    }

    //form表单进行PUT请求的时候会访问到这里（修改用户）可以直接换为@putmapping注解
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-zhangsan";
    }
}
