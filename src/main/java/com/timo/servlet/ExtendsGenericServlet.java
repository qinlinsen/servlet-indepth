package com.timo.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 这是写Servlet的第二种方法继承GenericServlet
 * @author 秦林森
 */
public class ExtendsGenericServlet extends GenericServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config);
        String servletName = config.getServletName();
        System.out.println("servletName="+servletName);
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println("s="+s);
        }
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("contextPath="+servletRequest.getServletContext().getContextPath());
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String element = attributeNames.nextElement();
            System.out.println("element="+element);
        }
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("ExtendsGenericServlet");
    }
}
