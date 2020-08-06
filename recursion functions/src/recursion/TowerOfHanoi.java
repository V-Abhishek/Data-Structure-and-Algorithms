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
public class TowerOfHanoi {

    public static void main(String[] args) {
        int numberOfDisks = 5;
        towerOfHanoiSolver(numberOfDisks, 'A', 'C', 'B');
    }

    static void towerOfHanoiSolver(int numberOfDisks, char source, char destination, char auxilary) {
        if (numberOfDisks == 1) {
            System.out.println("Disk " + numberOfDisks + " moved from " + source + " to " + destination);
            return;
        }
        towerOfHanoiSolver(numberOfDisks - 1, source, auxilary, destination);
        System.out.println("Disk " + numberOfDisks + " moved from " + source + " to " + destination);
        towerOfHanoiSolver(numberOfDisks - 1, auxilary, destination, source);
    }
}
