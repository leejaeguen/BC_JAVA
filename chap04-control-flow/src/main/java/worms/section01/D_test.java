package worms.section01;

import java.util.Scanner;

public class D_test {
    public void testNestedIfElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("점수");
        int score = sc.nextInt();

        String grade;

        if (score >= 95) {
            grade = "A+";
        } else if (score >= 90) {
            grade = "A";
        } else if (score >= 85) {
            grade = "B+";
        } else if (score >= 80) {
            grade = "B";
        }  else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println(name + "학생의 점수는 " + score + "점이고, 등급은 " + grade + "입니다.");
        System.out.println("프로그램을 종료합니다.");

    }
}
