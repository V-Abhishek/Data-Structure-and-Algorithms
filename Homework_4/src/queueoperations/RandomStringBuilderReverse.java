/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueoperations;

import java.security.SecureRandom;

/**
 *
 * @author Abhishek
 */
public class RandomStringBuilderReverse {

    private static String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static String NUMBER = "0123456789";
    private static String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            System.out.println(generateRandomString(500));
        }
    }

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            randomString.append(rndChar);
        }
        return randomString.reverse().toString();
    }

}
