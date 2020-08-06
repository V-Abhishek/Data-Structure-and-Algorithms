/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Abhishek
 */
public class Node {

    int element;
    Node left;
    Node right;

    public Node(int input) {
        this.element = input;
        left=right=null;
    }

}
