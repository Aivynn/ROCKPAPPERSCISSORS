package com.company;

import java.util.List;

import static com.company.Rules.checkCondition;

public class AsciiTable {

    public void createAsciiTable(int c, List<String> args) {
        String[] moves = new String[c + 1];
        moves[0] = "PC/USER";
        String[][] data = new String[c][c + 1];
        for (int i = 0, k = 1; i < moves.length - 1; i++, k++) {
            moves[k] = args.get(i);
            data[i][0] = args.get(i);
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0, ind = 1; j < c; j++, ind++) {

                data[i][ind] = checkCondition(i + 1, j + 1, c);
            }
        }
        System.out.println(com.github.freva.asciitable.AsciiTable.getTable(moves, data));

    }

}
