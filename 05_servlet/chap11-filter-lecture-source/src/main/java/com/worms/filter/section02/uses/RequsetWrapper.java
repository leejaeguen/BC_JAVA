package com.worms.filter.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequsetWrapper extends HttpServletRequestWrapper {
    public RequsetWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {

        String value = "";
        if("password".equals(key)) {

            /* 설명. key값으로 'password'가 넘어 오면 Bcrypt 암호화 진행 */
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(key));
            System.out.println("암호화된 값: " + value);

        } else{
            value = super.getParameter(key);
        }

        return value;
    }
}
