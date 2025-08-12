package org.example.arraytest;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;
        int sum = 0;

        sum += num1;
        sum += num2;
        sum += num3;
        sum += num4;
        sum += num5;
        System.out.println(sum);

        int[] arr = new int[5]; // heap 영역에 [0][0][0][0][0]
        // System.out.println(arr[0]);
        // System.out.println(arr);
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        /* 설명. 반복문 없이 1차원 배열 출력해보기 */
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(Arrays.toString(arr));
    }
}
