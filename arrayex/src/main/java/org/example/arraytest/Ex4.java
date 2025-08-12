package org.example.arraytest;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        /* 수업목표. 배열을 사용해서 예시를 작성할 수 있다. */
        int[] score = new int[5];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <score.length; i++) {
            System.out.print((i + 1) + "번째 학생의 자바 점수를 입력하세요: ");
            score[i] = sc.nextInt();
        }
        System.out.println("현재까지 입력된 점수들: " + Arrays.toString(score));

        /* 설명. 합계(sum) 구하기 */
        /* 설명.
         *  배열은 그 길이를 활용해야 할 때 length는 변수에 접근해서 활용할 수 있다.
         *  (유지보수 측면 및 입력된 크기의 배열이 할당될 때 사용할 것)
        * */

        /* 설명. 향상된 for문(또는 foreach문) 활용하기(feat.처음부터 끝까지 순회) */
        int sum = 0;

        for (int s : score) {
            sum += s;
        }
        System.out.println("합계: " + sum + "점");

        double avg = sum / (double)score.length;
        System.out.println("평균: " + avg);
    }
}
