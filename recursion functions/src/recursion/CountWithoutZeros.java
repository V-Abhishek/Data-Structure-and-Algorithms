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
public class CountWithoutZeros {

    public static int countBinaryString(int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 3;
        }
        return countBinaryString(n - 1) + countBinaryString(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of Binary Numbers without cosecutive 0's is " + countBinaryString(n));
    }
}
