package com.springboot.springbootdemo.converter;

import com.springboot.springbootdemo.bean.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class AbcMessageConverter implements HttpMessageConverter<User> {

    //读
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }


    //写
    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return aClass.isAssignableFrom(User.class);
    }

    /**
     * 服务器要统计所有MessageConverter都能写出哪些内容类型
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/abc");
    }

    @Override
    public User read(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(User user, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议数据的写出
        String data = user.getName()+";"+user.getAge();

        //写出去
        OutputStream body = httpOutputMessage.getBody();
        body.write(data.getBytes());
    }
}
