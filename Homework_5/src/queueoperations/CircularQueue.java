/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueoperations;

import java.util.Arrays;

/**
 *
 * @author Abhishek
 */
public class CircularQueue {

    private int currentSize;
    private int[] circularQueueElements;
    private int maxSize;
    private int rear;
    private int front;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = new int[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    public void enqueue(int input) {
        if (!isFull()) {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = input;
            currentSize++;

            if (front == -1) {
                front = rear;
            }
        } else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue() {
        int deQueuedElement;
        if (!isEmpty()) {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = 0;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        } else {
            System.out.println("Queue is empty");
            return 0;
        }
        return deQueuedElement;
    }

    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        return Arrays.toString(circularQueueElements);
    }

}
