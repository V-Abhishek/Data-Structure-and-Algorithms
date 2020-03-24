/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Abhishek
 */
public class MinHeap {

    public int capacity;
    public int[] minHeap;
    public int currentSize;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        minHeap = new int[capacity + 1];
        currentSize = 0;
    }

    public void createHeap(int[] arrA) {
        if (arrA.length > 0) {
            for (int i = 0; i < arrA.length; i++) {
                insert(arrA[i]);
            }
        }
    }

    public void display() {
        for (int i = 1; i < minHeap.length; i++) {
            System.out.print(" " + minHeap[i]);
        }
        System.out.println("");
    }

    public void insert(int x) {
        if (currentSize == capacity) {
            System.out.println("heap is full");
            return;
        }
        currentSize++;
        int idx = currentSize;
        minHeap[idx] = x;
        bubbleUp(idx);
    }

    public void bubbleUp(int pos) {
        int parentIdx = pos / 2;
        int currentIdx = pos;
        while (currentIdx > 0 && minHeap[parentIdx] > minHeap[currentIdx]) {
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx / 2;
        }
    }

    public int extractMin() {
        int min = minHeap[1];
        minHeap[1] = minHeap[currentSize];
        minHeap[currentSize] = 0;
        sinkDown(1);
        currentSize--;
        return min;
    }

    public void sinkDown(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k + 1;
        if (leftChildIdx < heapSize() && minHeap[smallest] > minHeap[leftChildIdx]) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < heapSize() && minHeap[smallest] > minHeap[rightChildIdx]) {
            smallest = rightChildIdx;
        }
        if (smallest != k) {
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    public void swap(int a, int b) {
        int temp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = temp;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int heapSize() {
        return currentSize;
    }

    public static void main(String args[]) {
        int input[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        System.out.println("Original Array : ");
        for (int i = 0; i < input.length; i++) {
            System.out.print("  " + input[i]);
        }
        MinHeap m = new MinHeap(input.length);
        System.out.println("\nMin-Heap :     ");
        m.createHeap(input);
        m.display();
        System.out.println("Extract Min :");
        for (int i = 0; i < input.length; i++) {
            System.out.print("  " + m.extractMin());
        }
    }
}
