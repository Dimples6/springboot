package com.springboot.springbootdemo.Hadnler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1.编写一个拦截器实现HandlerInterceptor
 * 2.将拦截器注册到容器中（实现WebMvcConfigurer下的方法addInterceptor）
 * 3.指定要拦截的页面，以及不拦截的页面
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器在容器中
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptors()) //添加拦截器
                .addPathPatterns("/**")  //添加需要拦截的页面,/**是拦截所有，就会连静态资源都拦截掉
                .excludePathPatterns("/login");   //不需要拦截的页面
    }
}
