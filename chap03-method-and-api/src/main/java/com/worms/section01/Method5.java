package com.worms.section01;

public class Method5 {
    public static void main(String[] args) {
        Method5 app = new Method5();
        app.testMethod();
        String returnStr = app.returnMethod();
        System.out.println("returnStr: " + returnStr);
        
        /* 설명. 굳이 반환값을 변수에 담지 않아도 된다. */
        System.out.println("반환값 바로 확인: " + app.returnMethod());
    }

    /* 설명. 반환이 없는 경우 */
    public void testMethod() {
        System.out.println("testMethod() 동작 확인...");

        return;
    }

    /* 설명. 반환을 String으로 하는 경우 */
    public String returnMethod() {
        System.out.println("returnMethod() 동작 확인");

        return "test";
    }
}
