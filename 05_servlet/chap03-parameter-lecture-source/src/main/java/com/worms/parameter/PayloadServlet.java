package com.worms.parameter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/payload")
public class PayloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 설명. tomcat 9버전 이하는 post요청일 때는 인코딩 설정을 하지 않으면 parameter의 한글이 깨질 수 있음 */
//        resp.setContentType("UTF-8");
        
        String name = req.getParameter("name");
        System.out.println("name:" + name);
        
        /* 설명. parameter들의 key값들을 한번에 순회하며 파악할 수 있기도 하다.(feat.Enumeration) */
        Enumeration<String> keyNames = req.getParameterNames();
        while (keyNames.hasMoreElements()) {
            System.out.println(keyNames.nextElement());
        }
    }
}
