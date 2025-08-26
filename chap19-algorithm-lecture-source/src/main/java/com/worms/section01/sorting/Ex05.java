package com.worms.section01.sorting;

/* 설명.
 *  병합 정렬(Merge Sort)
* */
public class Ex05 {

    public static void solution(int low, int high, int[] arr) {
        if (high - low == 0) return;    // 한 칸이면

        int median = low + (high - low) / 2;    // 현재 배열의 중앙 위치
        solution(low, median, arr);
        solution(median+1, high, arr);

        int[] temp;
        temp = arr.clone();

        /* 설명. 분할 정복 방식 시작 */
        int k = low;
        int index1 = low;
        int index2 = median + 1;

        while(index1 <= median && index2 <= high) {
//            if(temp[index1] < temp[index2]) {   // 오름차순을 위한 조건
            if(temp[index1] > temp[index2]) {   // 내림차순
                arr[k++] = temp[index1++];
            } else {
                arr[k++] = temp[index2++];
            }
        }

        // 좌측이 많이 남아있을 경우
        while(index1 <= median) {
            arr[k++] = temp[index1++];
        }

        // 우측이 많이 남아있을 경우
        while(index2 <= high) {
            arr[k++] = temp[index2++];
        }
    }

}
