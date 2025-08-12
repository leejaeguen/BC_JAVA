package section03;

public class Ex1 {
    /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */
    public static void main(String[] args) {
        User user1 = new User();
        System.out.println(user1.getInfo());

        User user2 = new User("user01", "홍길동", "usero01");
        System.out.println(user2.getInfo());
    }
}
