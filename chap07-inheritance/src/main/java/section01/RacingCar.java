package section01;

public class RacingCar extends Car {
    
    /* 설명. 부모로부터 물려받은 메소드들의 기능 재정의 */
    public void run() {
        System.out.println("자동차가 달리기 시작합니다. 매우 빠르게");

    }

    public void soundHorn() {
        System.out.println("레이싱카는 경적따위 울리지 않음");
    }

}
