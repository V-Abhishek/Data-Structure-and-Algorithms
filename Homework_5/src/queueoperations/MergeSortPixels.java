/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueoperations;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Abhishek
 */
public class MergeSortPixels {

    static void mergeSort(double arr[], int intialIndex, int midIndex, int lastIndex) {
        int array1Size = midIndex - intialIndex + 1;
        int array2Size = lastIndex - midIndex;

        double array1[] = new double[array1Size];
        double array2[] = new double[array2Size];
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

    static void sortSub(double input[], int intialIndex, int lastIndex) {
        if (intialIndex < lastIndex) {
            int mid = (intialIndex + lastIndex) / 2;
            sortSub(input, intialIndex, mid);
            sortSub(input, mid + 1, lastIndex);
            mergeSort(input, intialIndex, mid, lastIndex);
        }
    }

    public static void main(String[] args) {
        BufferedImage image;
        int width;
        int height;
        ArrayList<Double> arrayList = new ArrayList();

        try {
            File input = new File("C:\\Users\\Abhishek\\Downloads\\image.png");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    double intensity = (0.2989 * c.getRed() + 0.5870 * c.getGreen() + 0.1140 * c.getBlue());
                    arrayList.add(intensity);
                }
            }
            double[] toBeSorted = new double[arrayList.size()];
            int i = 0;
            for (Double d : arrayList) {
                toBeSorted[i] = d;
                i++;
            }
            sortSub(toBeSorted, 0, arrayList.size() - 1);
            for (int j = 0; j < toBeSorted.length; j++) {
                System.out.println(toBeSorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
    }

}
