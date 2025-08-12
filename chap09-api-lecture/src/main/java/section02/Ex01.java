package section02;

public class Ex01 {
    public static void main(String[] args) {
        /* 설명. 문자열 객체를 생성하는 다양한 방법을 숙지하고 문자열 인스턴스가 생성되는 방식을 이해할 수 있다. */
        /* 설명.
         *  문자열(객체)을 만드는 방법
         *  1. ""리터럴 형태: 동일한 값을 가지는 문자열 인스턴스(동등(e, h))를 단일 인스턴스로 관리한다.
         *                 (일종의 singleton 개념, heap의 상수로(constant poll) 활용)
         *  2. new String(""): 매번 새로운 인스턴스를 heap 영역에 생성한다.
        * */

        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str2 == str3: " + (str2 == str3));
        System.out.println("str3 == str4: " + (str3 == str4));

        System.out.println("str1의 주소: " + System.identityHashCode(str1));
        System.out.println("str2의 주소: " + System.identityHashCode(str2));
        System.out.println("str3의 주소: " + System.identityHashCode(str3));
        System.out.println("str4의 주소: " + System.identityHashCode(str4));
    }
}
