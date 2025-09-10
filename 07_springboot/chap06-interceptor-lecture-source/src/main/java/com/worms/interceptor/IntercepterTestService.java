package com.worms.interceptor;

import org.springframework.stereotype.Service;

@Service
public class IntercepterTestService {
    public void test() {
        System.out.println("Service bean을 활용한 메소드 호출");
    }
}
