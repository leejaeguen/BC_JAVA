package org.example.arraytest;

import java.util.Arrays;

public class Copy2 {
    public static void main(String[] args) {
        
        /* 수업목표. 깊은 복사에 대해 이해할 수 있다. */
        /* 설명.
         *  1. for문을 이용한 수동적인 복사
         *  2. Object의 clone()을 이용한 복사(사용빈도 높음)
         *  3. System의 arraycopy()를 이용한 복사
         *  4. Arrays의 copuOf()를 이용한 복사
        * */
        int[] originArr = new int[]{1, 2, 3, 4};
        print(originArr, "원본");

        /* 설명. 1. */
        int[] copyArr = new int[originArr.length];
        for (int i = 0; i < originArr.length; i++) {
            copyArr[i] = originArr[i];
        }
        print(copyArr, "for문을 이용한 사본");
        
        /* 설명. 2. */
        int[] copyArr2 = originArr.clone();
        print(copyArr2, "clone()을 이용한 사본");

        /* 설명. 3. */
        int[] copyArr3 = new int[originArr.length + 3];
        System.arraycopy(originArr, 0, copyArr3, 3, originArr.length);
        print(copyArr3, "arraycopy를 이용한 사본");
        
        /* 설명. 4. */
        int[] copyArr4 = Arrays.copyOf(originArr, originArr.length);
        print(copyArr4, "copyof()를 이용한 사본");
    }
    private static void print(int[] arr, String desc) {
        System.out.println("======" + desc + "======");
        System.out.println("넘어온 배열의 hashcode(10진수로 된 주소): " +arr.hashCode());
        System.out.println(Arrays.toString(arr));
    }
}
