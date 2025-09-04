package com.worms.filter.section01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(filterName = "secondFilter")
@WebFilter(filterName = "secondFilter", urlPatterns = "/*")
public class secondFilter implements Filter {
    public secondFilter() {
        System.out.println("Second Filter 기본생성자 호출");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter 인스턴스 생성!");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter 삭제 직전!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter의 doFilter() 호출됨...");

        /* 설명. FilterChain에서 제공하는 doFilter를 통해 다음 필터 또는 서블릿으로 진행라려는 의미이다. */
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("second: 서블릿 다녀온 이후 client로 응답 전");
    }
}
