package section01;

public class Ex01 {
    public static void main(String[] args) {
        /* 수업목표. 다형성과 타입 형변환에 대해 이해할 수 있다. */
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        System.out.println();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();

        System.out.println();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();

        Animal an1 = new Animal();  // 다형성 적용 X
        Animal an2 = new Tiger();   // 다형성 적용 O
        Animal an3 = new Rabbit();  // 다형성 적용 O

        Object an4 = new Animal();  // 다형성 적용 O

        // Tiger tr = new Animal(); // 다형성 적용 X

        an2.eat();              // 런타임 시점에는 오버라이딩 된 자식 객체의 메소드가 동작(동적 바인딩)
        // an3.jump();          // 컴파일 시점에는 아직 an3는 정적 바인딩만 지원
        ((Rabbit)an3).jump();   // 강제로 알려주면(강제 다운 캐스틍) 추가 메소드 호출 가능
    }
}
