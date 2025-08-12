package section03;

import java.io.Serializable;

/* 설명. 인터페이스는 다중 구현(implements)이 가능하다. */
public class Product implements InterProduct, Serializable, AnotherInterProduct {
    @Override
    public void nonStaticMethod(int num) {
        System.out.println("넘어온 값은 " + num + "입니다.");

    }

    @Override
    public void nonStaticMethod2() {

    }

    @Override
    public void plusItems(String itemName, int num) {

    }
}
