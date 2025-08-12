package worms.section02;

import java.util.Scanner;

public class Looping {
    public static void main(String[] args) {
    }

    public void testForExample() {
        /* 설명. 5개의 각 변수에 값들에 2를 곱하고 1을 더해 sum에 누적 */
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        int sum = 0;

        sum += num1 * 2 + 1;
        sum += num2 * 2 + 1;
        sum += num3 * 2 + 1;
        sum += num4 * 2 + 1;
        sum += num5 * 2 + 1;

        System.out.println("sum = " + sum);
        
        /* 설명. for문을 통해 개선해 보자.(feat. 규칙적이며 반복적인 코드들) */
        int forSum = 0;
        
        /* 설명. 디버깅 요령: 1. 반드시 되는 시점까지 돌리거나 주석해서 되게 만든다.
         *                 2. 코드를 한번에 많이 완벽하게 하고 실행하면 X
        * */
        for (int i = 0; i < 10; i += 2) {
            forSum += (i + 1) * 2 + 1;
        }
        System.out.println("forSum = " + forSum);
    }

    public void testForExample2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("반복횟수 입력: ");
        int Limit = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < Limit; i++) {
            sum += (i + 1);
        }
        System.out.println("sum = " + sum);
    }
}
