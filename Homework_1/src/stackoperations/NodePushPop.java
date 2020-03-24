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
public class NodePushPop {

    class Node {

        int age;
        String name;
        Node next;
    }
    Node top;

    public NodePushPop() {
        this.top = null;
    }
    public int size=0;
    public void push(int age, String name) {
        Node currentNode = new Node();
        currentNode.age = age;
        currentNode.name = name;
        currentNode.next = top;
        top = currentNode;
        size++;
    }

    public Object pop() {
        Node temp = null;
        if (isEmpty()) {
            System.out.print("Empty Stack");
            exit(1);
        }
        size--;
        temp = top;
        top = (top).next;
        return temp.age + "," + temp.name;
    }

    public boolean isEmpty() {
        if (top != null) {
            return false;
        } else {
            return true;
        }
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return -1;
        } else {
            return top.age + "," + top.name;
        }
    }
    
    public int size() {
        return size;
    }
}
