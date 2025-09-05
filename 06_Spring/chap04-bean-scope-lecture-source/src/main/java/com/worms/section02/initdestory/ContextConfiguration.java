package com.worms.section02.initdestory;

import com.worms.common.Beverage;
import com.worms.common.Bread;
import com.worms.common.Product;
import com.worms.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ContextConfiguration {
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 1500);
    }

    @Bean
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    // Bean 타입의 클래스에 정의된 메소드를 활용해서 bean 생성 및 소멸 시점에 호출할 수 있
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
}
