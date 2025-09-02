package com.worms.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 설명. HttpServletResponse를 활용해서 서버에서 페이지 만들어 응답 */
        StringBuilder responseTest = new StringBuilder();
        responseTest.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>한글servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        // MIME 타입과 인코딩 방식을 설정해줘야 함 (JakartaEE 이후 생략 가능하지만 가급적 작성하는 게 좋다
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print(responseTest);
        out.flush();
        out.close();
    }
}
