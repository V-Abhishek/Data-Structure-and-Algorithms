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
public class QuickSort {

    private void sort(int[] inputArray, int intialIndex, int finalIndex) {
        if (intialIndex < finalIndex) {
            int pivot = inputArray[intialIndex];
            int i = intialIndex;
            int j = finalIndex;
            while (i < j) {
                i += 1;
                while (i <= finalIndex && inputArray[i] < pivot) {
                    i += 1;
                }
                while (j >= intialIndex && inputArray[j] > pivot) {
                    j -= 1;
                }
                if (i <= finalIndex && i < j) {
                    swap(inputArray, i, j);
                }
            }
            swap(inputArray, intialIndex, j);
            sort(inputArray, intialIndex, j - 1);
            sort(inputArray, j + 1, finalIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }

}
