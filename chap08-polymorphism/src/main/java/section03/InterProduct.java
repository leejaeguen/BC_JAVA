package section03;

public interface InterProduct extends ParentInterProduct, AnotherInterProduct {

    /* 설명. 상수 필드 */
    public static final int MAX_NUM = 100;
    int MIN_NUM = 1;

    /* 설명. 인터페이스는 생성자를 가지지 않는다. */

    /* 설명. 추상 메소드 */
    public abstract void nonStaticMethod(int num);
    void nonStaticMethod2();

    /* 설명. JDK 1.8부터 추가된 body가 있는 메소드들*/
    public static void staticMethod(){

    }

    /* 설명. non-static 메소드 */
    public default void defaultMethod(){

    }

    /* 설명. private 접근 제어자 메소드 */
    private void privateMethod(){
    }


}
