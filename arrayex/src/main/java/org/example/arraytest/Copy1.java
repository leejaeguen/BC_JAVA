package org.example.arraytest;

import java.util.Arrays;

public class Copy1 {
    public static void main(String[] args) {

        /* 수업목표. 배열의 복사 개념 중 우선 얕은 복상에 대해 이해할 수 있다. */

        int[] originArr = {1, 2, 3};
        int[] copyArr = originArr;

        System.out.println(Arrays.toString(originArr));

        copyArr[1] = 100;
        System.out.println(Arrays.toString(originArr));

        testMethod(originArr);
        System.out.println("메소드 안에서의 변화가 반환하지 않아도 호출한 곳에 영향을 주는지: " + originArr[0]);
    }

    private static void testMethod(int[] arr) {
        System.out.println("메소드 안에서의 arr로 접근 시 모습: " + Arrays.toString(arr));
        arr[0] = 111;

    }
}
