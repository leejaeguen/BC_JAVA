package com.worms.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/* 설명. 같은 타입의 bean이 많을 경우 우선순위가 있는 bean을 설정할 수 있다.(feat. Primary) */
@Primary
@Component
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불공격!🔥");
    }
}
