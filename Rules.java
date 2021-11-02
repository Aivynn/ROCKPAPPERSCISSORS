package com.company;

import java.util.ArrayList;
import java.util.List;

public class Rules {
    public static String checkCondition(int humanMove, int computerMove, List<String> list) {

        String result = "tie";
        int moves = list.size() / 2;
        List<String> win = new ArrayList<>();
        int i = 0;
        int a = humanMove - moves;

        while(i<moves) {

            if(a < 0) {
                win.add(list.get(list.size() + a));
            }
            else {
                win.add(list.get(a));
            }
            a++;
            i++;
        }


        if(humanMove == computerMove) {
            return result;
        }
        else if(win.contains(list.get(computerMove))) {
            result = "lose";
            return result;
        }
        else {
            result = "win";
            return result;
        }
    }
}