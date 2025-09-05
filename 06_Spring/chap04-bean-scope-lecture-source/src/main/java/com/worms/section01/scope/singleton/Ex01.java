package com.worms.section01.scope.singleton;

import com.worms.common.Product;
import com.worms.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        /* 설명. 붕어빵, 우유, 물을 진열 */
        Product carpBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Product.class);

        /* 설명. 첫 번째 손님 입장 후 쇼핑 카트를 꺼내 물건을 담는다. */
        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("첫 번째 손님의 카트: " + cart1);
        
        /* 설명. 두 번째 손님 입장 후 쇼핑 카트에 물건을 담는다. */
        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("두 번째 손님의 카트: " + cart2);
    }
}
