package com.worms.exceptionhandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /* 설명. 다른 서블릿에서 우리가 설정한 에러(404, 500)가 발생해서 넘어오면 request에 attribute로 추가된 값들 */
        Enumeration<String> attrNames = req.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        int statusCode = (Integer) req.getAttribute("jkata.servlet.error.status_code");
        String message = (String) req.getAttribute("jkata.servlet.error.message");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        System.out.println("statusCode: " + statusCode);
        System.out.println("message: " + message);
        System.out.println("servletName: " + servletName);

        /* 설명. 위의 재료를 가지고 만드는 동적인 에러 페이지 생성 및 응답 */
        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>")
                .append("<br>\n")
                .append("<p>에러 발생한 서블릿 명: ")
                .append(servletName)
                .append("</p>");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(errorPage);
        out.flush();
        out.close();
    }
}
