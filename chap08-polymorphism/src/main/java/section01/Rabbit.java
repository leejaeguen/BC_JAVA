package section01;

public class Rabbit extends Animal{
    @Override
    public void eat() {
        System.out.println("풀 냠");
    }
    @Override
    public void run() {
        System.out.println("깡총");
    }
    @Override
    public void cry() {
        System.out.println("끼익");
    }
    public void jump() {
        System.out.println("잠푸");
    }
}
