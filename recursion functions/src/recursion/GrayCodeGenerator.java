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
public class GrayCodeGenerator {

    public static void main(String[] args) {
        int n = 4;
        gray("", n);
    }

    public static void gray(String prefix, int n) {
        if (n == 0) {
            System.out.print(prefix + ", ");
        } else {
            gray(prefix + "0", n - 1);
            reflectedGray(prefix + "1", n - 1);
        }
    }

    private static void reflectedGray(String prefix, int n) {
        if (n == 0) {
            System.out.print(prefix + ", ");
        } else {
            gray(prefix + "1", n - 1);
            reflectedGray(prefix + "0", n - 1);
        }
    }

}
