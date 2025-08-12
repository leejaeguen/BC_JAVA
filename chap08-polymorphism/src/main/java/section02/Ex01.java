package section02;

public class Ex01 {
    public static void main(String[] args) {

        Phone smartphone = new Phone();
        Product p = new Phone();             // 다형성

        /* 설명. 객체를 생성할 수 없는 불완전한 클래스로써의 추상클래스 */
        // Product product = new Product();  // 추상 클래스가 되면 생성자를 통한 객체를 생성할 수 없다.

        smartphone.abstractMethod();   // 추상 메소드를 물려받아 오버라이딩 한 메소드
        smartphone.nonStaticMethod();
        smartphone.staticMethod();
        Product.staticMethod();

        p.abstractMethod();
        p.nonStaticMethod();
    }
}
