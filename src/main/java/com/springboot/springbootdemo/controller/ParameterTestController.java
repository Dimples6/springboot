package com.springboot.springbootdemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    /**
     * 其他的一些注解的表示
     *@PathVariable 路径变量
     *@RequestHeader 获取请求头
     *@RequestParam 获取请求参数（前端某个变量带参数到后端，用这个注解可以直接获取到该变量的参数）
     * @CookieValue 获取cookie的值
     *  @RequestBody 获取请求体（post）请求，就是表单请求里面有多个字段数
     */
    @RequestMapping("/car/{id}/{userName}")
    public Map<String,Object> car(@PathVariable("id") String id, @PathVariable("userName") String userName, @PathVariable Map<String,Object> pv,
                                  @RequestHeader("User-Agent") String userAgent,
                                  @RequestParam("age") Integer age){
        System.out.println(age);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("userName",userName);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("age",age);
        return map;
    }


    /*@MatrixVariable（注解的使用方法） 前端写的格式  /cars/sell;low=22;brand=body,lis
    还要配合webConfig类里面的webMvcConfigurer方法打开这个矩阵变量才可以*/
    @RequestMapping("/cars/{path}")
    public Map cars(@MatrixVariable("low") Integer low,
                    @MatrixVariable("brand") List<String> brand
                    ){

        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        return map;
    }


    /*/boss/1;age=20/2;age=10   两个一样的变量请求进来*/
    @RequestMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
