package com.company;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    AsciiTable table = new AsciiTable();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    GenerateKey key = new GenerateKey();

    public void startGame(int c, List<String> args) throws NoSuchAlgorithmException, InvalidKeyException {



        System.out.println("Choose your move, from 1 to " + c);
        String userMove = scanner.next();
        if (userMove.equals("?")) {
            table.createAsciiTable(c, args);
        } else {
            Integer user = Integer.valueOf(userMove);
            int computerMove = random.nextInt(c);
            String computer = args.get(computerMove);
            String secretKey = key.generateSecretKey();
            String hmac = key.generateHMAC(secretKey, computer);
            System.out.println("Secret key - " + secretKey + "\n" + "hmac - " + hmac);
            System.out.println(args.get(user - 1) + " " + args.get(computerMove));
            System.out.println("Human - " + Rules.checkCondition(user - 1, computerMove, c));
            System.out.println("Wanna play one more time ?" + " yes/no");

        }
    }
}
