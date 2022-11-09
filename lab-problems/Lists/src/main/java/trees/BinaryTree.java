/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trees;

import java.util.Stack;

/**
 *
 * @author jacob
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>> {

    Node<E> root;

    class Node<E> {

        E e;
        Node<E> lChild;
        Node<E> rChild;
    }

    public boolean insert(E e) {
        Node<E> newNode = new Node<E>();
        newNode.e = e;
        //1. tree is empty
        if (this.root == null) {
            root = newNode;
        } else {
            Node<E> p = root;
            Node<E> pTrail = root;

            while (p != null) {
                if (p.e.compareTo(e) == 0) {
                    System.out.println("duplicates not allowed");
                    return false;
                }
                if (e.compareTo(p.e) > 0)// go right
                {
                    pTrail = p;//points to the parent of 
                    p = p.rChild;
                } else//go right
                {
                    pTrail = p;//points to the parent of 
                    p = p.lChild;
                }
            }

            if (pTrail.e.compareTo(e) > 0)//we make the new node left child
            {
                pTrail.lChild = newNode;
            } else {
                pTrail.rChild = newNode;
            }

        }
        return true;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> p) {
        if (p == null) {
            return;
        }
        System.out.println(p.e);//visit node
        preOrder(p.lChild);//go left
        preOrder(p.rChild);//go right
    }

    public void inOrder() {
        inOrderLoop();
//        inOrder(root);
    }

    private void inOrder(Node<E> p) {
        if (p == null) {
            return;
        }

        inOrder(p.lChild);//go left
        System.out.println(p.e);//visit node
        inOrder(p.rChild);//go right

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> p) {
        if (p == null) {
            return;
        }
        postOrder(p.lChild);//go left
        postOrder(p.rChild);//go right
        System.out.println(p.e);//visit node

    }

    private void inOrderLoop() {
        Stack<Node<E>> stack = new Stack();
        stack.push(root);

        Node<E> p = root;

        while (stack.empty() == false) {

            while (p != null) {
                p = p.lChild;
                if (p != null) {
                    stack.push(p);
                }
            }

            Node<E> topOfStack = stack.pop();
            System.out.println(topOfStack.e);

            if (topOfStack.rChild != null) {
                p = topOfStack.rChild;
                stack.push(p);
            }
        }
    }

    public int sizeLoops() {

        Stack<Node<E>> stack = new Stack();
        stack.push(root);

        int count = 0;
        Node<E> p = root;

        while (stack.empty() == false) {

            while (p != null) {
                p = p.lChild;
                if (p != null) {
                    stack.push(p);
                }
            }

            Node<E> topOfStack = stack.pop();
            System.out.println(topOfStack.e);
            ++count;

            if (topOfStack.rChild != null) {
                p = topOfStack.rChild;
                stack.push(p);
            }
        }
        return count;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<E> p) {
        if (p == null) {
            return 0;
        }
        return 1 + size(p.lChild) + size(p.rChild);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree();
        bt.insert(100);
        bt.insert(120);
        bt.insert(130);
        bt.insert(80);
        bt.insert(1);
        bt.insert(2);
        bt.insert(90);
        bt.insert(110);

        System.out.println("==== Order ====");
        bt.inOrder();

        System.out.println("==== Preorder ====");
        bt.preOrder();

        System.out.println("==== Postorder ====");
        bt.postOrder();

        System.out.println("==== In Order ====");
        bt.inOrderLoop();

        System.out.println("==== Size ====");
        System.out.println(bt.size());

        System.out.println("==== Size Non Recursive====");
        System.out.println(bt.sizeLoops());

    }
}
