package com.amos.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Amos
 * @date 2020-10-28 20:45
 * 在没有登录的情况下，不能让游客访问到后台管理页面，在这里就需要加一个登录拦截器.
 * 将访问路径给过滤掉，这里就用SpringBoot里面内置的interceptor,重写预处理方法，进行拦截
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if(request.getSession().getAttribute("user") == null)
        {
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
