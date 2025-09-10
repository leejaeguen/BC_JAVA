package com.worms.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/* 설명.
 *  1. bean을 다룰 수 있다 (필터와의 차이점)
 *  2. 핸들러 메소드 직전/직후에 동작하여 전후 처리를 한다
 *     (forward 및 redirect 일지라도 매번 핸들러 메소드 실행 시 동작함)
 *  3. 이후에 진행될 핸들러 메소드의 동작 여부를 제어할 수 있다 (preHandle의 반환형을 통해)
 *  4. Interceptor 사용 목적
 *     : 로그인 체크, 권한 체크 (인증 및 인가), 프로그램 실행 시간 계산 작업 로그 처리,
 * */

@Component
public class StopwatchInterceptor implements HandlerInterceptor {

    IntercepterTestService testService;

    @Autowired
    public StopwatchInterceptor(IntercepterTestService testService) {
        this.testService = testService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 호출함 (핸들러 메소드 이전)");

        // 스톱워치 기능
        long startTime = System.currentTimeMillis();    // 시스템의 현재 시간을 밀리초 단위 long형으로 반환
        request.setAttribute("startTime", startTime);

        // 사용자의 로케일 추출
        Locale locale = request.getLocale();
        System.out.println("locale = " + locale);
        if("ko_KR".equals(locale)) System.out.println("한국인이시군요");

        // Service bean 활용 (메소드 호출)
        testService.test();

        // 핸들러 인터셉터의 preHandler가 반환하는 boolean형에 따라 Controller의 핸들러 메소드 동작여부 조절 가능
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호출함 (핸들러 메소드 이후)");
        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        // postHandle의 ModelAndView는 Conroller의 핸들러메소드가 반환한 내용(재료) + 뷰가 담겨있다
        modelAndView.addObject("interval", endTime - startTime + "(ms)");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
