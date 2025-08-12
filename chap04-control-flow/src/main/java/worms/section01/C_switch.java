package worms.section01;

import java.util.Scanner;

public class C_switch {
    public void testSimpleSwitchStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("본인의 등급을 입력하세요(G, S, B): ");
        char grade = sc.next().charAt(0);
        // chat grade = "Gold".charAt(0);
        System.out.println(grade);

        int point = 0;
        switch (grade) {
            case 'G':
                point += 100;
                break;
            case 'S':
                point += 50;
                break;
            case 'B':
                point += 30;
                break;
            default:
                System.out.println("입력을 잘 보고 해주세요.");
        }
        System.out.println("포인트: " + point);
    }
}
