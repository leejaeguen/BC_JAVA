package section02.encapsulation;

public class Problem1 {

    /* 수업목표. 필드에 직접 접근하는 경우 발생하는 문제점을 이해할 수 있다. */
    public static void main(String[] args) {
        Monster monster01 = new Monster();
        monster01.name = "드라큘라";
        monster01.setHp(200);

        Monster monster02 = new Monster();
        monster02.name = "프랑켄";
        monster02.setHp(-300);

        System.out.println("mobster01의 이름: " + monster01.name);
        System.out.println("monster01의 체력: " + monster01.hp);

        System.out.println("mobster02의 이름: " + monster02.name);
        System.out.println("monster02의 체력: " + monster02.hp);
    }
}
