/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperations;

/**
 *
 * @author Abhishek
 */
public class LinkedListForStack {

    public static void main(String[] args) {
        NodePushPop linkedlist = new NodePushPop();
        linkedlist.push(31, "Name1");
        linkedlist.push(24, "Name2");
        linkedlist.push(10, "Name3");
        linkedlist.push(44, "Name4");
        linkedlist.push(81, "Name5");
        linkedlist.push(33, "Name6");
        //Printing the POPED Elements
        System.out.print("{" + linkedlist.pop() + "}");
        System.out.print("{" + linkedlist.pop() + "}");
    }

}
