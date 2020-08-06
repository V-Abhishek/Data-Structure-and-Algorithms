/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueoperations;

/**
 *
 * @author Abhishek
 */
public class ArrayQueueImpl {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        System.out.println("Queue is empty? " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue is empty? " + queue.isEmpty());
        System.out.println("De-queue item:" + queue.dequeue());

    }
}
