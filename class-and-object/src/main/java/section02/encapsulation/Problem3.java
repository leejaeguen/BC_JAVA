package section02.encapsulation;

public class Problem3 {
    public static void main(String[] args) {
        Monster3 m = new Monster3();

        m.setInfo1("뿌꾸");
        m.setInfo2(100);
        System.out.println(m.getInfo());

        /* 설명.
         *  캡슐화(Encapsulation)이란?
         *   캡슐화는 유지보수성을 증가시키기 위해 필드(클래스의 속성)의 직접 접근을 제한하고,
         *   public 메소드를 이용해서 간접적으로(우회해서) 접근하여 사용할 수 있도록 만든 기술이다.
         *   클래스 작성 시 특별한 목적이 있지 않다면 모든 필드에 대해 캡슐화를 적용하는 것을 원칙으로 하고있다.
        * */
    }
}
