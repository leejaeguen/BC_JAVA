package com.worms.section01.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/* 수업목표. 버블 정렬을 이해할 수 있다. */
/* 설명.
 *  버블 정렬(Bubble Sort)
 *   두 인접한 데이터의 크기를 비교해 정렬하는 방법이다.
 *   버블의 모든 요소에 대해 반복하면서, 각 반복마다 가장 큰(작은) 요소가 배열의 끝으로
 *   "버블링(이동)" 된다.
 *   사건복잡도는 O(n^2)이라 효율적이지는 않다.(feat.데이터의 크기가 10000이라면 위험)
* */

class Application1Test {
    private static int input1, input2;
    private static int[] act1, act2;
    private static int[] exp1, exp2;

    @BeforeAll
    public static void set() {

        /* 설명. 예시 1 */
        input1 = 7;
        act1 = new int[]{34, 23, 5, 24, 1, 9, 12};
        exp1 = new int[]{1, 5, 9, 12, 23, 24, 34};

        /* 설명. 예시 2 */
        input2 = 6;
        act2 = new int[]{40, 47, 38, 8, 33, 35};
        exp2 = new int[]{8, 33, 35, 38, 40, 47};
    }

    public static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(input1, act1, exp1),
                Arguments.of(input2, act2, exp2)
        );
    }

    @DisplayName("버블 정렬 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    public void bubbleSortTest(int length, int[] actual, int[] expected) {
        Ex01.solution(length, actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}