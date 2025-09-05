package com.worms.section02.initdestory;

import com.worms.common.Product;
import com.worms.common.ShoppingCart;
import com.worms.section01.scope.singleton.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        // 붕어빵, 우유, 물을 진열 (컨테이너에서 꺼냄)
        Product carpBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Product.class);

        // 첫 번째 손님 입장 후 쇼필 카트를 꺼내 물건을 담는다
        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);
        System.out.println("첫 번재 손님의 카트: " + cart1);

        // 두 번째 손님 입장 후 쇼필 카트에 물건을 담는다
        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("두 번재 손님의 카트: " + cart2);

        // main 메소드 종료 전 Container를 제거 (bean 제거 강제)
        ((AnnotationConfigApplicationContext)context).close();
    }
}
