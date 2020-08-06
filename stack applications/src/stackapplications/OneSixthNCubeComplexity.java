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
public class OneSixthNCubeComplexity {
    
    public static void main(String[] args) {
        int counter=0;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    System.out.println("This is 1/6 N^3 complexity Program.");
                    counter+=1;
                }
            }
        }
        System.out.println("Conter "+counter);
    }
}
