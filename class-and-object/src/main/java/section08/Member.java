package section08;

public class Member {
    private int num;
    private String id;
    private String pwd;
    private String name;
    private int age;
    private char gender;

    public Member(){}

    public Member(int num, String id, String pwd, String name, int age, char gender) {
        this.num = num;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {}
}
