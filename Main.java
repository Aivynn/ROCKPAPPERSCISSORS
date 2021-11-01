package com.company;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        List<String> unique = Arrays.stream(args).distinct().collect(Collectors.toList());

        int c = unique.size();
        if (c % 2 == 0) {
            System.out.println("Wrong quantity of moves, try odd number");
            System.exit(1);
        }

        System.out.println("Available moves: ");
        for (int i = 0; i < unique.size(); i++) {
            System.out.println(i + 1 + " - " + unique.get(i));
        }
        System.out.println("? " + "- help");
        System.out.println("0 " + "- exit");
        game.startGame(c, unique);
        while (true) {
            System.out.println("Wanna play one more time ?" + " yes/no");
            String anotherGame = scanner.next();
            if (anotherGame.toLowerCase(Locale.ROOT).equals("yes")) {
                game.startGame(c, unique);
            } else {
                System.exit(1);
            }
        }
    }
}