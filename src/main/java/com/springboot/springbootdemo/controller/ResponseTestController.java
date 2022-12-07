package com.springboot.springbootdemo.controller;

import com.springboot.springbootdemo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
/*@RestController*/
public class ResponseTestController {

    /**
     * 1.浏览器发送请求直接返回xml   [application/xml]         jacksonXmlConverter
     * 2.如果是ajax发送请求返回json    [application/json]     jacksonJsonConverter
     * 3.如果是abc发送请求，返回自定义协议数据   [application/abc]       xxxxConverter
     *
     *步骤：
     * 1.添加自定义MessageConverter进系统底层
     * 2.系统底层统计出所有MessageConverter能操作哪些类型
     * 3.客户端内容协商
     *
     * @return
     */
    @ResponseBody  //利用返回值处理器里面的消息转换器进行处理
    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setAge(18);
        user.setName("zhanshan");
        return user;
    }
}
