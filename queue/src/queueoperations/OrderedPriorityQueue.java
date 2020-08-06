/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueoperations;

import java.util.PriorityQueue;

/**
 *
 * @author Abhishek
 */
public class OrderedPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> input = new PriorityQueue<>();
        input.add(3);
        input.add(10);
        input.add(5);
        input.add(12);
        input.add(20);
        input.add(9);
        input.add(41);
        input.add(6);
        input.add(11);
        input.add(50);
        input.add(24);
        input.add(14);
        while (!input.isEmpty()) {
            System.out.println(input.remove());
        }
    }
}
