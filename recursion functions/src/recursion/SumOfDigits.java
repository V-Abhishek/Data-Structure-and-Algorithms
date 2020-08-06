/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Abhishek
 */
public class SumOfDigits {

    public static void main(String[] args) {
        int input = 26497;
        System.out.println("Sum of Digits:" + sumDigits(input));
    }

    static int sumDigits(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (number == 0) {
            return 0;
        }
        return (number % 10 + sumDigits(number / 10));
    }
}
