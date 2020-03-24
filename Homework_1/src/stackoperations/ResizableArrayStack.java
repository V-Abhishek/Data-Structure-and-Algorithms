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
public class ResizableArrayStack {

    public static void main(String[] args) {
        DynamicPushPop inputArray = new DynamicPushPop(2);
        inputArray.push(inputArray.new Node(31, "Name1"));
        inputArray.push(inputArray.new Node(24, "Name2"));
        inputArray.push(inputArray.new Node(10, "Name3"));
        inputArray.push(inputArray.new Node(44, "Name4"));
        inputArray.push(inputArray.new Node(81, "Name5"));
        inputArray.push(inputArray.new Node(81, "Name6"));
        inputArray.push(inputArray.new Node(81, "Name7"));
        //Printing the POPED Elements
            System.out.print("{" + inputArray.pop() + "}");
            System.out.print("{" + inputArray.pop() + "}");
    }
}
