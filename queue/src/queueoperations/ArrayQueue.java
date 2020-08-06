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
public class ArrayQueue {

    int front;
    int rear;
    int size;
    int[] array;

    public ArrayQueue(int size) {
        this.size = size;
        front = rear = 0;
        array = new int[size];
    }

    public void enqueue(int number) {
        if (rear != size) {
            array[rear] = number;
            rear++;
        }
    }

    public int dequeue() {
        int temp;
        if (front != rear) {
            temp = array[0];
            for (int i = 0; i < rear - 1; i++) {
                array[i] = array[i + 1];
            }
            if (rear < size) {
                array[rear] = 0;
            }
            rear--;
            return temp;
        }
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (front == rear);
    }
}
