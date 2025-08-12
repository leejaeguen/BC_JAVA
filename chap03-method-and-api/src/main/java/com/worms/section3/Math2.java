package com.worms.section3;

public class Math2 {
    public static void main(String[] args) {
        /* 설명. 0 ~ 9까지 난수 생성 */
        int random1 = (int)(Math.random() * 10);

        /* 설명. 80 ~ 90까지 난수 생성 */
        int random2 = (int)(Math.random() * 21) + 80;

        /* 설명. -188 ~ 10까지 난수 생성 */
        int random3 = (int)(Math.random() * 199) - 188;

        System.out.println("random1: " + random1);
        System.out.println("random2: " + random2);
        System.out.println("random3: " + random3);
    }
}
