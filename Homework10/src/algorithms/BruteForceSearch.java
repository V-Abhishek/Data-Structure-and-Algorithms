/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Abhishek
 */
public class BruteForceSearch {

    public static void search(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCADCBABABCDABCDABDE";
        String pattern = "BCD";
        search(text, pattern);
    }

}
