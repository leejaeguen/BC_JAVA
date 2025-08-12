package parameter;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(){

    }

    public Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    }

    public void calArea(){
        System.out.println("이 사각형의 넓이는: " + (height * width));
    }

    public void calRound(){
        System.out.println("이 사각형의 둘레는: " + (height + width) * 2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
