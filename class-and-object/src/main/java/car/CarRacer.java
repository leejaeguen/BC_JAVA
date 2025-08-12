package car;

public class CarRacer {

    private Car myCar = new Car();

    public void startUp() {
        this.myCar.startup();
    }

    public void stepAccelator() {
        this.myCar.go();
    }

    public void stop() {
        this.myCar.stop();
    }

    public void turnoff() {
        this.myCar.turnoff();
    }
}
