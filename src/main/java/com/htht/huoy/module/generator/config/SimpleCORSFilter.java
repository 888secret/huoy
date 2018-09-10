package com.htht.huoy.module.generator.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SimpleCORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.setHeader("access-control-allow-origin","http://localhost:8002");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("access-control-allow-methods","post,get,options,delete");
        response.setHeader("access-control-max-age","3600");
        response.setHeader("access-control-allow-headers","content-type, x-requested-with");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
