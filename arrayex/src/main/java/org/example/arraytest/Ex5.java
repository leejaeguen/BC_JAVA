package org.example.arraytest;

public class Ex5 {
    public static void main(String[] args) {
        String[] shape = {"SPADE", "COLVER", "HEART", "DIAMOND"};
        String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING","ACE"};

        int randomShape = (int)(Math.random() * 4);
        int randomNumber = (int)(Math.random() * number.length);

        System.out.println("카드 \"" + shape[randomShape] + " " + number[randomNumber] + "\"");
    }
}
