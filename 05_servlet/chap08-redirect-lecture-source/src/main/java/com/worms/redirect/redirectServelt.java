package com.worms.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class redirectServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("라더아랙투 아휴 request의 attribute 확인: " + req.getAttribute("test"));
        System.out.println("라더아랙투 아휴 request의 parameter 확인: " + req.getParameter("test"));
    }
}
