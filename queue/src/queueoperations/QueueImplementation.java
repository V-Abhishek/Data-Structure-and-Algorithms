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
public class QueueImplementation {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        System.out.println("Queue Empty ? " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue Size " + queue.size());
        System.out.println("De-queued item: " + queue.dequeue().number);
        System.out.println("Queue Size " + queue.size());
    }

}
