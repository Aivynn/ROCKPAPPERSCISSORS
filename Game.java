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

        int computerMove = random.nextInt(c);
        String computer = args.get(computerMove);
        String secretKey = key.generateSecretKey();
        String hmac = key.generateHMAC(secretKey, computer);
        System.out.println("hmac - " + hmac);
        System.out.println("Enter your move: ");
        String userMove = scanner.next();
        if( userMove.equals("0")) {
            System.exit(1);
        }
        if (userMove.equals("?")) {
            table.createAsciiTable(c, args);
            System.exit(1);
        } else {
            int user = Integer.parseInt(userMove);
            System.out.println("Secret key - " + secretKey);
            System.out.println("Human move - " + args.get(user) + " Computer move - " + args.get(computerMove));
            System.out.println("Human - " + Rules.checkCondition(user, computerMove, args));

        }
    }
}
