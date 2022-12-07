package com.springboot.springbootdemo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @RequestAttribute 获取reques域属性
 */

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goTo(HttpServletRequest request){

        request.setAttribute("msg","成功了");
        return "forward:/success"; //将请求(forwards是转发)转发到success里
    }


    /**
     *无论是map还是model类型springboot底层都会调用mavContainer.getModel();方法，获取到值的
     */
    @RequestMapping("/parmst")
    public String parmst(Map<String,Object> map,
                         Model model,
                         HttpServletRequest request,
                         HttpServletResponse response){

        map.put("word","hello");
        model.addAttribute("hello","word");
        request.setAttribute("haha","heihei");
        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);

        return  "forward:/success";
    }

    //equired = false表示request（请求域中）不是必须的
    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg" ,required = false) String msg,
                       HttpServletRequest request){

        Object msg1 = request.getAttribute("msg");

        Object word = request.getAttribute("word");
        Object hello = request.getAttribute("hello");
        Object haha = request.getAttribute("haha");


        Map<String,Object> map =  new HashMap<>();
         map.put("msg",msg);
         map.put("requestMsg",msg1);
         map.put("word",word);
         map.put("hello",hello);
         map.put("haha",haha);

        return map;
    }
}
