/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Arrays;

/**
 *
 * @author Abhishek
 */
public class KeyIndexed {
    
    public static void main(String[] args) {
        
        String input = "ABDCEDDFCABBEECCEFDDAAF";
        KeyIndexed keyIndexed = new KeyIndexed();
        char[] inputChar = input.toCharArray();
        keyIndexed.sort(inputChar);
        System.out.println(Arrays.toString(inputChar));
        
    }
    
    void sort(char arr[]) {
        int n = arr.length;
        char output[] = new char[n];
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i) {
            count[i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            ++count[arr[i]];
        }
        for (int i = 1; i <= 255; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < n; ++i) {
            arr[i] = output[i];
        }
    }
}
