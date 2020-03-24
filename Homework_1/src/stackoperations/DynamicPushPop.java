/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperations;

import static java.lang.System.exit;

/**
 *
 * @author Abhishek
 */
public class DynamicPushPop {

    int size;
    int index = 0;
    Node array[];

    class Node {

        int age;
        String name;

        public Node(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public DynamicPushPop(int size) {
        this.size = size;
        array = new Node[size];
    }

    public void push(Node input) {
        if (index == size) {
            Node[] expandedArray = new Node[2 * size];
            System.arraycopy(array, 0, expandedArray, 0, array.length);
            size *= 2;
            array = expandedArray;
        }
        array[index] = input;
        index++;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            exit(1);
        }
        Node temp = null;
        temp = array[index - 1];
        --index;
        int checkSize = index;
        if (checkSize <= (size / 2) / 2) {
            size = size / 2;
            Node[] shrinkeddArray = new Node[size];
            System.arraycopy(array, 0, shrinkeddArray, 0, shrinkeddArray.length);
            array = shrinkeddArray;

        }
        return temp.age + "," + temp.name;
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return -1;
        } else {
            return array[index - 1].age + "," + array[index - 1].name;
        }
    }

    public int size() {
        return size;
    }
}
