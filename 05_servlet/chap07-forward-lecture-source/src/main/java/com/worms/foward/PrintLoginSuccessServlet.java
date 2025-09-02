package com.worms.foward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==포워딩되어 넘어온 request 객체에 담긴 값 확인==");
        System.out.println("이름: " + req.getAttribute("userName"));
        System.out.println("아이디: " + req.getParameter("userId"));
        System.out.println("패스워드: " + req.getParameter("password"));
    }
}
