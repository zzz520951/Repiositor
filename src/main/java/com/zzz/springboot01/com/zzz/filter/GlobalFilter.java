package com.zzz.springboot01.com.zzz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义Filter
 */
@WebFilter(filterName = "GlobalFilter")
public class GlobalFilter implements  Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        filterChain.doFilter(request, servletResponse);
    }
}
