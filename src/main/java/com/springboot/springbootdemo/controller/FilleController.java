package com.springboot.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FilleController {

    @PostMapping(value = "fills")
    public String fill(@RequestParam("username") String username,  //前端传入单个值获取
                       @RequestPart("fills")  MultipartFile fills, //接收前端传的文件
                       @RequestPart("fillss") MultipartFile[] fillss   //多文件
                       ) throws IOException {

        if(!fills.isEmpty()){//不为空
            String originalFilename = fills.getOriginalFilename();//获取图片原生的名字
            fills.transferTo(new File("D:\\"));//将文件保存到某个位置
        }

        if(fillss.length > 0){//多文件数组遍历保存到某个位置
            for (MultipartFile multipartFile : fillss) {
                if(!multipartFile.isEmpty()){
                    String originalFilename = fills.getOriginalFilename();//获取图片原生的名字
                    fills.transferTo(new File("D:\\"));//将文件保存到某个位置
                }
            }
        }

        return null;
    }
}
