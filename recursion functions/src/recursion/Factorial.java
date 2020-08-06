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
public class Factorial {

    public static void main(String[] args) {
        int input = 6;
        System.out.println("Factorial " + factorial(input));
    }

    static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
