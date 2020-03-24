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
public class CircularQueueImpl {

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(9);
        circularQueue.enqueue(7);
        circularQueue.enqueue(28);
        circularQueue.enqueue(3);
        circularQueue.enqueue(9);
        circularQueue.enqueue(12);
        circularQueue.enqueue(82);
        circularQueue.enqueue(10);
        circularQueue.enqueue(31);
        circularQueue.enqueue(24);
        circularQueue.dequeue();
        circularQueue.dequeue();
        System.out.println(circularQueue);
    }

}
