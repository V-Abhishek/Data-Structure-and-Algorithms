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
public class FibonacciIterative {

    public static void main(String[] args) {
        int input = 5;
        int first = 0;
        int second = 1;
        int sum = 0;
        if (input == 0) {
            System.out.println("0");
        } else if (input == 1 || input == 2) {
            System.out.println("1");
        } else {
            for (int i = 1; i < input; i++) {
                sum = first + second;
                first = second;
                second = sum;
            }
            System.out.println(sum);
        }
    }
}
