/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperations;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Abhishek
 */
public class StackForAString {

    public static void main(String[] args) {
        String inputString = "It was the best of time";
        Stack<String> stack = new Stack<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, " ");
        //Push the string on to the stack
        while (stringTokenizer.hasMoreTokens()) {
            stack.push(stringTokenizer.nextToken());
        }
        //Pop the stack elements
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
