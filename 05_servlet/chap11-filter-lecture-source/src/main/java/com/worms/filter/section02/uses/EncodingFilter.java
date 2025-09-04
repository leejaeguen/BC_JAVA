package com.worms.filter.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("인코딩 설정용 필터 지나감");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명.
         *  톰켓 10버전 이전에는 post 요청일 때는 인코딩 설정을 하지 않ㅇ므녀 한글이 깨지곤 했다.
         *  우린 10버전 톰캣이라 굳이 해주지 않아도 동작하지만 현업에서 경우에 따라 필요할 수도 있고
         *  추가로 다른 인코딩 설정으로 바꿀 때도 활용할 수 있다.
        * */
        if ("Post".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
