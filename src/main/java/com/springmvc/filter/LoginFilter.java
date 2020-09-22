package com.springmvc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    //获取会话域对象
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse ;
        //从会话域中获取用户数据
        HttpSession session=request.getSession();
        Object username=session.getAttribute("username");
        //有会话域数据说明已经登录了
        if(username!=null){
          filterChain.doFilter(request,response);
          return;
        }
        //没有就没有权限访问
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    @Override
    public void destroy() {

    }
}
