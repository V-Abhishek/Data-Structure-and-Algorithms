/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperations;

import stackoperations.ArrayPushPop.Node;

/**
 *
 * @author Abhishek
 */
public class ArraysForStack {

    public static void main(String[] args) {
        ArrayPushPop inputArray = new ArrayPushPop(5);
        inputArray.push(inputArray.new Node(31, "Name1"));
        inputArray.push(inputArray.new Node(24, "Name2"));
        inputArray.push(inputArray.new Node(10, "Name3"));
        inputArray.push(inputArray.new Node(44, "Name4"));
        inputArray.push(inputArray.new Node(81, "Name5"));
        //Printing the POPED Elements
            System.out.print("{" + inputArray.pop() + "}");
            System.out.print("{" + inputArray.pop() + "}");
            
    }

}
