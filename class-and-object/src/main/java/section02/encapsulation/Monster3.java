package section02.encapsulation;

public class Monster3 {
    private String name;
    private int hp;

    public void setInfo1(String info1){
        this.name = info1;
    }

    public void setInfo2(int info2){
        this.hp = info2;
    }
    public String getInfo(){
        return this.name + "의 hp는" + this.hp;
    }
}
