package com.timo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 我们可以吧Filter看成一种特殊的servlet，其init()方法在服务器tomcat启动的时候调用，
 * 当路径匹配到<filter-mapping>标签下的   <url-pattern>/某某/某某</url-pattern>时
 * 就会调用doFilter()方法
 * @author 秦林森
 */
public class HelloWorldFilter implements Filter{
    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        //得到filter的名字
        String filterName = filterConfig.getFilterName();
        System.out.println("filterName="+filterName);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
        //转发至/a/b/c
        servletRequest.getRequestDispatcher("/a/b/c").forward(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
