package com.zentcode.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    
    private static final String CODE = "lambda-999";
    
    public static String generateHash(String password) {
        StringBuilder hash = new StringBuilder();
        String codedPassword = CODE + password;

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(codedPassword.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'a', 'b', 'c', 'd', 'e', 'f' };
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                    byte b = hashedBytes[idx];
                    hash.append(digits[(b & 0xf0) >> 4]);
                    hash.append(digits[b & 0x0f]);
            }
        } catch(NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
        }

        return hash.toString();
    }
}