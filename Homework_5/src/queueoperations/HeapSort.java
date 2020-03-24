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
public class HeapSort {

    static void heapify(int inputArray[], int length, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < length && inputArray[l] < inputArray[smallest]) {
            smallest = l;
        }
        if (r < length && inputArray[r] < inputArray[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[smallest];
            inputArray[smallest] = temp;
            heapify(inputArray, length, smallest);
        }
    }

    static void heapSort(int inputArray[], int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(inputArray, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {

            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            heapify(inputArray, i, 0);
        }
    }

    public static void main(String[] args) {
        int inputArray[] = {27, 43, 38, 3, 9, 82, 10, 33, 19, 15};
        int length = inputArray.length;
        heapSort(inputArray, length);
        System.out.println(Arrays.toString(inputArray));
    }

}
