package dto;

public class Overloading {

    /* 수업목표. 오버로딩(Overloading)에 대해 이해할 수 있다. */
    /* 설명.
     *  메소드의 시그니처?
     *   public void method(int num){} 이라면, 메소드의 메소드명과 파라미터 선언부 부분을
     *   메소드의 시그니처(signature)라고 한다.(즉, method(int num))
     *
     * 설명.
     *  동일한 메소드 이름으로 다양한 종류의 매개변수에 따라 처리해야 하는 경우 적용하는 기술을
     *  오버로딩이라고 한다.
     *
     * 설명.
     *  오버로딩의 조건?
     *   매개변수의 타입, 갯수, 순서를 다르게 작성하여 하나의 클래스 내에 동일한 이름의 메소드를
     *   여러개 작성할 수 있다.
    * */

    public void test() {}

    public void test(int num){}

    public void test(int num, int num2){}

    // public void test() {}

    // public void test(int num2, int num){}

    public void test(int num, String str){}

    public void test(String str, int num){}
}
