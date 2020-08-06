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
public class FibonacciRecursive {

    public static void main(String[] args) {
        int input = 5;
        if (input < 0) {
            throw new IllegalArgumentException();
        } else {
            System.out.println(fibonacci(input));
        }

    }

    static int fibonacci(int n) {
        {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
