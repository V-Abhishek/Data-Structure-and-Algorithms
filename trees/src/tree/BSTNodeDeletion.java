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
class BSTNodeDeletion {

    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    static Node root;

    BSTNodeDeletion() {
        root = null;
    }

    static void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    static Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    static int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BSTNodeDeletion bSTNodeDeletion = new BSTNodeDeletion();
        bSTNodeDeletion.insert(42);
        bSTNodeDeletion.insert(12);
        bSTNodeDeletion.insert(53);
        bSTNodeDeletion.insert(8);
        bSTNodeDeletion.insert(16);
        bSTNodeDeletion.insert(60);
        bSTNodeDeletion.insert(2);
        bSTNodeDeletion.insert(22);
        bSTNodeDeletion.insert(57);
        bSTNodeDeletion.insert(65);
        bSTNodeDeletion.insert(19);
        bSTNodeDeletion.insert(11);
        BSTNodeDeletion.deleteKey(65);
        BSTNodeDeletion.deleteKey(60);
        BSTNodeDeletion.deleteKey(42);
        bSTNodeDeletion.inorder();

    }
}
