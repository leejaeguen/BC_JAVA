package com.worms.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출됨...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출됨...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("req = " + req);
        System.out.println("res = " + res);

        /* 설명. Http Method를 확인하기 위해 실제 객체 타입인 HttpServletXXX 계열로 다운캐스팅 후 확인 */
        HttpServletRequest httpRequest = (HttpServletRequest)req;
        HttpServletResponse httpResponse = (HttpServletResponse)res;

        String httpMethod = httpRequest.getMethod();

        /* 설명.
         *  기본적으로 쓰는 Http Method 방식
         *  1. GET - 조회
         *  2. POST - 추가
         *  3. PUT / PATCH - 수정
         *  4. DELETE - 삭제
        * */

        if ("GET".equals(httpMethod)) {
            doGet(httpRequest, httpResponse);
        } else if ("POST".equals(httpMethod)) {
            doPost(httpRequest, httpResponse);
        }


    }
}
