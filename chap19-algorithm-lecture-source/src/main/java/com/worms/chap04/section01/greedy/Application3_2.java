package com.worms.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Application3_2 {

    /* 설명. 2차원 배열 및 람다식 활용(feat.익명 클래스) */
    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            time[i][0] = start;
            time[i][1] = end;
        }

//        Arrays.sort(time, new  Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });

        Arrays.sort(time, (o1, o2) -> o1[1] - o2[1]);

//        for(int[] arr: time){
//            System.out.println(Arrays.toString(arr));
//        }

        int lastEndTime = 0;
        for (int i = 0; i < N; i++) {
            if (time[i][1] == time[i][1]) {
                max_count++;
                continue;
            }
            if (time[i][0] >= lastEndTime) {
                max_count++;
                lastEndTime = time[i][1];
            }
        }

        return max_count;
    }
}
