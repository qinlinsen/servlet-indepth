package com.timo.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 这是写Servlet的第一种方法实现Servlet接口，所以我的类名取ImplementServlet
 * 从这里可以看出servlet的生命周期（所谓的生命周期就是servlet）
 * @author 秦林森
 */
public class ImplementServlet implements Servlet {
    /**
     * 在服务器tomcat启动时调用该方法，该方法只会被调用一次
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        Object renmin = servletConfig.getServletContext().getAttribute("renmin");
        String name = servletConfig.getInitParameter("name");
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("name="+name);
        String age = servletConfig.getInitParameter("age");
        System.out.println("age="+age);
        System.out.println("servletContext="+servletContext);
        System.out.println("renmin="+renmin);
        System.out.println("*****************************************************");
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String element = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(element);
            System.out.println(element+"="+value);
        }
    }

    public ServletConfig getServletConfig() {
        return getServletConfig();
    }

    /**
     * servlet中处理业务逻辑的方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=utf-8");
        String contextPath = servletRequest.getServletContext().getContextPath();
        System.out.println("contextPath="+contextPath);
        String renmin = servletRequest.getServletContext().getInitParameter("renmin");
        System.out.println("renmin="+renmin);
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        outputStream.print("hello world");
    }

    public String getServletInfo() {
        return null;
    }

    /**
     * 服务器关闭时调用该方法
     */
    public void destroy() {
        System.out.println("服务器关闭时调用该方法");
    }
}
