package section01;

public class Ex1 {

    /* 설명.
     *  객체지향프로그래밍(OOP)란?
     *  OOP(Object Oriented Programming Language)
     *  : 추상화, 캢슐화, 상속, 다형성을 적용하여 유지보수성을 고려한 응집력 높고 결합도 낮음
     *    객체 위주의 개발방식을 추구하는 프로그래밍을 말한다.
     *
     * 설명.
     *  객체지향의 특징(4대 특징)
     *  - 추상화(Abstraction) / 이걸 빼면 3대 특징
     *  - 캡슐화(Encapsulation)
     *  - 상속(Inheritance)
     *  - 다형성(Polymorphism)
    * */
    public static void main(String[] args) {

        /* 설명. 클래스 없이 여러 타입으로 여러 값을 관리할 경우 */
        /* 설명.
         *  1. 많은 변수들을 따로 관리하기 어렵다.(한묶음으로 생각하거나 코딩할 수 없다.)
         *  2. 메소드의 전달인자로 전달할 값이 많아지므로 매개변수의 갯수가 늘어난다.
         *     (냄새나는 코드 -> 리펙토링의 징조)
         *  3. 메소드의 반환형으로는 하나의 타입만 가능하지만 클래스가 없이는 여러 속성을 반환하는 것이 불가능
        * */

        Member member1 = new Member();
        Member member2 = new Member();

        /* 설명. 사람 한명씩 접근해 이름을 부여하는 느낌의 코드 */
        member1.name = "김철수";
        member2.name = "김영희";

        /* 설명. 김영희씨만 우선 완성해보자 */
        member2.age = 19;
        member2.gender= '여';
        member2.hobbies = new String[]{"볼링", "하키"};
        member2.id = "user02";
        member2.pwd = "user02";

        System.out.println("김영희씨 이름과 나이를 말해주세요: \n" + member2.name + "이고, 나이는 " + member2.age);

        int num = 1;
        testMethod(member2, num);
        System.out.println("개명 이후 이름 " + member2.name);
        System.out.println("메소드를 호출할 때 넘겨준 n의 값: " + num);

        /* 설명.
         *  기본자료형의 값을 넘길 때 vs 참조자료형의 값을 넘길 때
         *  1. 기본자료형은 메소드를 호출한 곳이 영향을 받지 X
         *  2. 참조자료형은 메소드를 호출한 곳이 영향을 받을 수 O(feat. 반환을 할 필요 X)
        * */
    }

    private static void testMethod(Member m, int n) {
        System.out.println("개명하고 싶어!~");
        m.name = "김용희";
        n += 10;
        System.out.println("메소드 안에서의 n의 값: " + n);
    }
}
