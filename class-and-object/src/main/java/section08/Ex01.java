package section08;

public class Ex01 {
    public static void main(String[] args) {
        Car car1 = new Car("페라리", 300);
        Car car2 = new Car("람보르기니", 320);
        Car car3 = new Car("롤스로이스", 150);
        Car car4 = new Car("부가티", 330);
        Car car5 = new Car("포터", 400);

        car1.driveMaxSpeed();
        car2.driveMaxSpeed();
        car3.driveMaxSpeed();
        car4.driveMaxSpeed();
        car5.driveMaxSpeed();

        Car[] carArr = new Car[5];
        carArr[0] = new Car("페라리", 300);
        carArr[1] = new Car("람보르기니", 320);
        carArr[2] = new Car("롤스로이스", 150);
        carArr[3] = new Car("부가티", 330);
        carArr[4] = new Car("포터", 400);

        for (int i = 0; i < carArr.length; i++) {
            carArr[i].driveMaxSpeed();

        }


    }
}
