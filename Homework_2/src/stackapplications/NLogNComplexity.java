/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapplications;

/**
 *
 * @author Abhishek
 */
public class NLogNComplexity {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j = j + i) {
                System.out.println("This NLogN complexity program.");
            }
        }
    }
}

