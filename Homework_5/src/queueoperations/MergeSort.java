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
public class MergeSort {

    void mergeSort(int arr[], int intialIndex, int midIndex, int lastIndex) {
        int array1Size = midIndex - intialIndex + 1;
        int array2Size = lastIndex - midIndex;

        int array1[] = new int[array1Size];
        int array2[] = new int[array2Size];
        for (int i = 0; i < array1Size; ++i) {
            array1[i] = arr[intialIndex + i];
        }
        for (int j = 0; j < array2Size; ++j) {
            array2[j] = arr[midIndex + 1 + j];
        }

        int i = 0, j = 0;
        int k = intialIndex;
        while (i < array1Size && j < array2Size) {
            if (array1[i] <= array2[j]) {
                arr[k] = array1[i];
                i++;
            } else {
                arr[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < array1Size) {
            arr[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2Size) {
            arr[k] = array2[j];
            j++;
            k++;
        }
    }

    void sortSub(int input[], int intialIndex, int lastIndex) {
        if (intialIndex < lastIndex) {
            int mid = (intialIndex + lastIndex) / 2;
            sortSub(input, intialIndex, mid);
            sortSub(input, mid + 1, lastIndex);
            mergeSort(input, intialIndex, mid, lastIndex);
        }
    }

    public static void main(String args[]) {
        int inputArray[] = {27, 43, 38, 3, 9, 82, 10, 33, 19, 15};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sortSub(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }

}
