package section04.aggregate;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private int memNo;
    private String id;
    private String pwd;
    private int age;
    private String[] hobbies;
    private BloodType bloodType;
    private AccountStatus accountStatus;

    public Member() {}

    // 전체 필드 생성자
    public Member(int memNo,
                  String id,
                  String pwd,
                  int age,
                  String[] hobbies,
                  BloodType bloodType,
                  AccountStatus accountStatus) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
        this.age = age;
        this.hobbies = hobbies;
        this.bloodType = bloodType;
        this.accountStatus = accountStatus;
    }

    // 편의 생성자 (회원가입 시 자주 쓰는 형태)
    public Member(String id,
                  String pwd,
                  int age,
                  String[] hobbies,
                  BloodType bloodType) {
        this(0, id, pwd, age, hobbies, bloodType, AccountStatus.ACTIVE);
    }

    public int getMemNo() { return memNo; }
    public void setMemNo(int memNo) { this.memNo = memNo; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String[] getHobbies() { return hobbies; }
    public void setHobbies(String[] hobbies) { this.hobbies = hobbies; }

    public BloodType getBloodType() { return bloodType; }
    public void setBloodType(BloodType bloodType) { this.bloodType = bloodType; }

    public AccountStatus getAccountStatus() { return accountStatus; }
    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memNo=" + memNo +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", bloodType=" + bloodType +
                ", accountStatus=" + accountStatus +
                '}';
    }
}