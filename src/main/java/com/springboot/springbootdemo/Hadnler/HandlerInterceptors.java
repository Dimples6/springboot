package com.springboot.springbootdemo.Hadnler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器步骤：
 * 1.要配置好拦截器要拦截哪些请求
 * 2.把配置放在容器中
 *
 */
public class HandlerInterceptors implements HandlerInterceptor {

    /**
     * 目标执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //写方法
        HttpSession session = request.getSession();
        Object aa = session.getAttribute("aa");
        if(aa != null){
            //放行
            return true;
        }

        response.sendRedirect("bb"); //response的重定向


        /*request.setAttribute("msg","请登录");
        request.getRequestDispatcher("bb").forward(request,response);//request的重定向,可以携带消息到前端页面*/
        return false;
    }

    /**
     * 目标执行完成后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 页面渲染后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
