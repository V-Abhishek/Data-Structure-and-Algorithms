/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Abhishek
 */
public class TwoThreeTree<T extends Comparable<T>> implements Iterable<T> {

    class Node<T extends Comparable<T>> {

        List<T> values = new ArrayList<T>();
        List<Node<T>> children = new ArrayList<Node<T>>();

        boolean isLeaf() {
            return children.size() == 0;
        }

        boolean isFourNode() {
            return values.size() == 3;
        }

        Node(T x) {
            values.add(x);
        }

        Node(T x, Node<T> left, Node<T> right) {
            values.add(x);
            children.add(left);
            children.add(right);
            children.add(null);
        }

        public String toString() {
            String answer = "[";
            for (int i = 0; i < values.size(); i++) {
                if (i != 0) {
                    answer += ", ";
                }
                if (children.size() != 0) {
                    answer += children.get(i).toString();
                }
                answer += values.get(i);
            }
            if (children.size() != 0) {
                answer += children.get(children.size() - 2).toString();
            }
            return answer + "]";
        }

        void getVals(List<T> iteratorList) {
            for (int i = 0; i < values.size(); i++) {
                if (children.size() != 0) {
                    children.get(i).getVals(iteratorList);
                }
                iteratorList.add(values.get(i));
            }
            if (children.size() != 0) {
                children.get(children.size() - 2).getVals(iteratorList);
            }
        }

        boolean add(T val) {
            if (isLeaf()) {
                return addToLeaf(val);
            } else {
                return addToInterior(val);
            }
        }

        boolean addToLeaf(T x) {
            int compareResult;

            for (int i = 0; i < values.size(); i++) {
                compareResult = x.compareTo(values.get(i));
                if (compareResult == 0) {
                    return false;
                } else if (compareResult < 0) {
                    values.add(i, x);
                    return true;
                }
            }
            values.add(x);
            return true;
        }

        boolean addToInterior(T x) {
            int cmp;

            for (int i = 0; i <= values.size(); i++) {
                if (i == values.size()) {
                    cmp = -1;
                } else {
                    cmp = x.compareTo(values.get(i));
                }
                if (cmp == 0) {
                    return false;
                } else if (cmp < 0) {
                    boolean retVal = children.get(i).add(x);
                    if (children.get(i).isFourNode()) {
                        childIs4Node(i);
                    }
                    return retVal;
                }
            }
            return false;
        }

        void childIs4Node(int i) {
            System.out.println("childIs4Node " + i);
            System.out.println(this);
            Node<T> the4Node = children.get(i);
            System.out.println(the4Node);

            if (i == 2) {
                values.add(children.get(i).values.get(1));
            } else {
                values.add(i, children.get(i).values.get(1));
            }
            Node<T> newChild1, newChild2;
            if (children.get(i).isLeaf()) {
                newChild1 = new Node<T>(children.get(i).values.get(0));
                newChild2 = new Node<T>(children.get(i).values.get(2));
            } else {
                newChild1 = new Node<T>(children.get(i).values.get(0),
                        children.get(i).children.get(0),
                        children.get(i).children.get(1));
                newChild2 = new Node<T>(children.get(i).values.get(2),
                        children.get(i).children.get(2),
                        children.get(i).children.get(3));
            }
            children.remove(the4Node);
            children.add(i, newChild2);
            children.add(i, newChild1);
        }
    }

    Node<T> root;

    public TwoThreeTree() {
        root = null;
    }

    public boolean add(T val) {
        if (root == null) {
            root = new Node<T>(val);
            return true;
        } else {
            boolean isNew = root.add(val);
            if (root.values.size() == 3) {
                System.out.println("Split " + val);
                Node<T> left, right;
                if (root.isLeaf()) {
                    left = new Node<T>(root.values.get(0));
                    right = new Node<T>(root.values.get(2));
                } else {
                    left = new Node<T>(root.values.get(0),
                            root.children.get(0),
                            root.children.get(1));
                    right = new Node<T>(root.values.get(2),
                            root.children.get(2),
                            root.children.get(3));
                }
                root = new Node<T>(root.values.get(1), left, right);
            }
            return isNew;
        }
    }

    public Iterator<T> iterator() {
        List<T> values = new ArrayList<T>();
        if (root != null) {
            root.getVals(values);
        }
        return values.iterator();
    }

    public static void main(String[] args) {
        TwoThreeTree<Integer> set = new TwoThreeTree<Integer>();
        set.add(3);
        set.add(7);
        set.add(9);
        set.add(23);
        set.add(45);
        set.add(1);
        set.add(5);
        set.add(14);
        set.add(55);
        set.add(24);
        set.add(13);
        set.add(11);
        set.add(8);
        set.add(19);
        set.add(4);
        set.add(31);
        set.add(35);
        set.add(56);
        System.out.println("Tree " + set.root);
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
        set.add(17);
        set.add(22);
        set.add(32);
        System.out.println("Tree " + set.root);
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }
}
