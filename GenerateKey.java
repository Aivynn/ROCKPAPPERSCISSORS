package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Formatter;

public class GenerateKey {

    public String generateSecretKey() throws NoSuchAlgorithmException {
        SecureRandom secure = new SecureRandom();
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        keyGen.init(secure);
        byte[] bytes = new byte[128 / 8];
        secure.nextBytes(bytes);
        String originalKey = Base64.getEncoder().encodeToString(bytes);
        return originalKey;
    }

    public String generateHMAC(String key, String computer) throws InvalidKeyException, NoSuchAlgorithmException {

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(secretKey);
        byte[] hex = mac.doFinal(computer.getBytes(StandardCharsets.UTF_8));
        Formatter formatter = new Formatter();
        for (byte b : hex) {
            formatter.format("%02x", b);
        }
        return formatter.toString();


    }

}
