package com.company;

public class Rules {

    public static String checkCondition(int a, int b, int c) {

        String result = "";
        int distance = b - a;
        if (distance < 0) {
            distance += c;
        }
        int sentences = distance % 2;
        if (b == a) {
            result = "Tie";
            return result;
        } else if (sentences == 0) {
            result = "Won";
            return result;

        } else {
            result = "Lose";
            return result;
        }
    }

}
