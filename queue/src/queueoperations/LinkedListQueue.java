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
public class LinkedListQueue {

    NodeQueue front;
    NodeQueue rear;
    private int size = 0;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int number) {
        NodeQueue temp = new NodeQueue(number);
        if (rear == null) {
            this.front = temp;
            this.rear = temp;
            size++;
        } else {
            rear.next = temp;
            rear = temp;
            size++;
        }
    }

    public NodeQueue dequeue() {
        NodeQueue temp;
        if (front == null) {
            return null;
        }
        temp = front;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}
