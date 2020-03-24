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
public class HeapSortPixels {

    static void heapify(double inputArray[], int length, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < length && inputArray[l] > inputArray[largest]) {
            largest = l;
        }
        if (r < length && inputArray[r] > inputArray[largest]) {
            largest = r;
        }
        if (largest != i) {
            double temp = inputArray[i];
            inputArray[i] = inputArray[largest];
            inputArray[largest] = temp;
            heapify(inputArray, length, largest);
        }
    }

    static void heapSort(double inputArray[], int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(inputArray, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            double temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;
            heapify(inputArray, i, 0);
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
            heapSort(toBeSorted, toBeSorted.length);
            for (int j = 0; j < toBeSorted.length; j++) {
                System.out.println(toBeSorted[j]);
            }

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
    }

}
