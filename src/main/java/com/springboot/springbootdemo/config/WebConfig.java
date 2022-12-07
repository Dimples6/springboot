package com.springboot.springbootdemo.config;

import com.springboot.springbootdemo.bean.User;
import com.springboot.springbootdemo.converter.AbcMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class WebConfig {


    //这个是表单请求rest功能，自定义一个，修改默认的_method
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }


    //使用矩阵变量的注解springboot还需要配置这个，把原本移除;后面的内容给关掉
    //WebMvcConfigurer这个是所有配置的入口
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //不移除;后面内容。矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }


            //自定义的convert（（传回来的数据：阿猫，13）前端传回来的数据是这样的时候可以使用自定义的）
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, User>() {
                    @Override
                    public User convert(String s) {
                        //判断s不为空
                        if(!StringUtils.isEmpty(s)){
                            User user = new User();
                            String[] split = s.split(",");
                            user.setName(split[0]);
                            user.setAge(Integer.parseInt(split[1]));
                            return user;
                        }
                        return null;
                    }
                });
            }

            /**
             * 自定义配置一个返回数据的格式,这是请求头的application/abc
             * @param converters
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new AbcMessageConverter());
            }



            /**
             * url上面加format参数的自定义
             * 自定义协商策略
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypeMap = new HashMap<>();
                mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
                mediaTypeMap.put("xml",MediaType.APPLICATION_XML);
                mediaTypeMap.put("abc",MediaType.parseMediaType("application/abc"));
                //指定支持解析哪些参数对应哪些参数类型
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);

                //指定请求头
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
            }
        };
    }
}
