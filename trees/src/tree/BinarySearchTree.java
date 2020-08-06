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
public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int element) {
        root = insertNode(root, element);
    }

    Node insertNode(Node root, int element) {
        if (root == null) {
            root = new Node(element);
            return root;
        }
        if (element < root.element) {
            root.left = insertNode(root.left, element);
        } else if (element > root.element) {
            root.right = insertNode(root.right, element);
        }
        return root;
    }

    void inOrderTraversal() {
        inOrderTraversal(root);
    }

    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.element);
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(40);
        bst.insert(23);
        bst.insert(58);
        bst.insert(48);
        bst.insert(26);
        bst.insert(11);
        bst.insert(13);
        bst.inOrderTraversal();

    }
}
