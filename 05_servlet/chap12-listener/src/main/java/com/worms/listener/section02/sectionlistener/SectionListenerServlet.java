package com.worms.listener.section02.sectionlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SectionListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("Servlet에서 session 출력: "
                            + session.getClass().getName());

        session.setAttribute("userName", "hong"); // 추가
        session.setAttribute("age", 20);  // 추가
        session.setAttribute("age", 21);  // 수정
        session.removeAttribute("userName");  // 삭제

        session.setAttribute("user", new UserDTO("hong", 10));
        session.removeAttribute("user");

    }
}
