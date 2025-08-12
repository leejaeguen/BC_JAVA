package section02;

public class Phone extends Product {

    public Phone(){
        super();
    }

    @Override
    public void abstractMethod() {
        System.out.println("오버라이딩 했다.");
    }
}
