package car;

import java.security.spec.RSAOtherPrimeInfo;

public class Car {

    private boolean isOn = false;

    private int speed;

    public void startup() {
        if (this.isOn) {
            System.out.println("이미 걸려있잖아");
        }else{
            this.isOn = true;
            System.out.println("시동 걸림");
        }
    }

    public void go() {
        if (this.isOn) {
            this.speed += 10;
            System.out.println("차가 움직인다. 현재" + speed + "(km/hr)");
        } else{
            System.out.println("차가 꺼져있잖아.");
        }
    }

    public void turnoff() {
        if (this.isOn) {
            if (speed > 0) {
                speed = 0;
                System.out.println();
            } else {
                this.isOn = false;
                System.out.println("시동끈다");
            }
        }else{
            System.out.println("시동 꺼져있잖아");
        }
    }

    public void stop() {
        if (this.isOn) {
            if (speed > 0) {
                speed = 0;
                System.out.println("차 멈춤");
            } else {
                System.out.println("이미 멈춰있었음");
            }
        } else {
            System.out.println("차 시동 안걸려있짢아");
        }

    }
}
