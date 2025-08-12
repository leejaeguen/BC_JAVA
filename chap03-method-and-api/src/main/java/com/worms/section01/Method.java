package com.worms.section01;

public class Method {
    public static void main(String[] args) {
        /* 수업목표. 메소드의 호출 흐름(Method Call)에 대해 이해할 수 있다. */
        System.out.println("main() 시작함...");
        methodA();              // 원래  static 메소드는 클래스명.메소드명() 해야됨
        Method.methodA();       // static 메소드가 같은 클래스일 경우 생략 가능
        System.out.println("main() 종료합...");
    }
    public static void methodA() {
        System.out.println("methodA() 호출함...");
        methodB();
        System.out.println("methodA() 종료함...");
    }
    public static void methodB() {
        System.out.println("methodB() 호출함...");

        System.out.println("methodB() 종료함...");
    }

}
