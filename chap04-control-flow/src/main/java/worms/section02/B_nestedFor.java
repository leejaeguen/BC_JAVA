package worms.section02;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwotoNine() {
        /* 설명.
         *  2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   ...
         *  9단
         *   ...
         *   9 * 9 = 81
        * */


        for (int i = 1; i < 9; i++) {
            System.out.println((i + 1) + "단");
            /* 설명. 메소드로 빼낼 수 있다. */
            for (int j = 0; j < 9; j++) {
                System.out.println((i + 1) + " * " + (j + 1) + " = " + ((i + 1) * (j + 1)));
            }
        }

    }

}
