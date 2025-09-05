package com.worms.section01.scope.singleton;

import com.worms.common.Beverage;
import com.worms.common.Bread;
import com.worms.common.Product;
import com.worms.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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

    /* 설명.
     *  bean 스코프를 수정하게 되면 bean의 life cycle을 다른 추가로 기져갈 수 있다.
    * */
    @Bean
    // @Scope("singleton")
    @Scope("prototype")  // 매번 새로운 bean 객체 할당
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

}
