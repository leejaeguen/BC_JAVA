package section02;

import java.util.Date;

public class Computer extends Product {
    private String cpu;
    private int hdd;
    private int ram;
    private String operatingSystem;

    public Computer(){
    }
    public Computer(String cpu, int hdd, int ram, String operatingSystem) {
        super();
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }
    public Computer(String code, String brand, String name, int price, Date manufactureDate, String cpu, int hdd, int ram, String operatingSystem) {
        super(code, brand, name, price, manufactureDate);
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        /* 설명. 자식 클래스의 필드만 문자열로 바꿔주고 있음 */
//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operatingSystem='" + operatingSystem + '\'' +
//                '}';

        /* 설명. 부모 클래스의 필드값도 확인해 보기1 */

//        return this.getCode() + ", " + // 부모 객체에 있는 메소드에 접근하는거라 super. 라고 생각하면 됨
//                this.getBrand() + ", " +
//                this.getName() + ", " +
//                this.getPrice() + ", " +
//                this.getManufactureDate() + ", " +
//                "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operatingSystem='" + operatingSystem + '\'' +
 //               '}';

        /* 설명. 부모 클래스의 필드값도 확인해 보기2 */
        return super.toString() + "Computer{" +  // 반드시 super. 을 써서 부모객체에 있는 toString()을 인지 시킬 것
                "cpu='" + cpu + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}
