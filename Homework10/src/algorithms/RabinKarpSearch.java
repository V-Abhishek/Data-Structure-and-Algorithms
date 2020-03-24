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
public class RabinKarpSearch {

    public final static int d = 256;

    static void search(String pattern, String text, int q) {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCADCBABABCDABCDABDE";
        String pattern = "BCD";
        int q = 101;
        search(pattern, text, q);
    }
}
