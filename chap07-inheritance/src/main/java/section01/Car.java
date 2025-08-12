package section01;

public class Car /*extends Object*/{
    private boolean runingStatus;

    public Car() {
        super();
        System.out.println("부모 클래스의 기본 생성자 호출됨 ..,");
    }

    public void soundHorn() {
        if (runingStatus) System.out.println("빵빵");
        else System.out.println("경적 울릴 수 없음");
    }

    public void run() {
        runingStatus = true;
        System.out.println("자동차가 달리기 시작합니다.");

    }

    public void stop() {
        runingStatus = false;
        System.out.println("자동차가 멈춥니다.");
    }

}
