package section03;

public class SuperClass {

    /* 수업목표. 오버라이딩에 대해 이해할 수 있다. */
    /* 설명. 멤버(필드 + 메소드) + 생성자에는 public / protected / default / private 네 가지가 있다. */
    public void method(int num){}

    public Object method2(int num){
        return null;
    }

    private void privateMethod(){}

    public static final void finalMethod(){}

    /* 설명. protected */
    protected void protectedMethod(){}

    /* 설명. default */
    void defaultMethod(){}
}
