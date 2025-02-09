/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4q2;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author ACER
 */
public class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void clear() {
        root = null;
    }

    public Node search(String x) {
        return search(root, x);
    }

    Node search(Node root, String key) {
        if (root == null || root.info.equals(key))
            return root;
        if (key.compareTo(root.info) < 0)
            return search(root.left, key);
        return search(root.right, key);
    }

    void insert(String key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, String key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key.compareTo(root.info) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.info) > 0)
            root.right = insertRec(root.right, key);
        return root;
    }

    void breadth() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.info + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        System.out.println();
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.info + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.info + " ");
            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.info + " ");
        }
    }

    int count(Node root) {
        if (root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public void delete(String x) {
        root = delete(root, x);
    }

    Node delete(Node root, String key) {
        if (root == null)
            return root;
        if (key.compareTo(root.info) < 0)
            root.left = delete(root.left, key);
        else if (key.compareTo(root.info) > 0)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.info = minValue(root.right);
            root.right = delete(root.right, root.info);
        }
        return root;
    }

    String minValue(Node root) {
        String minv = root.info;
        while (root.left != null) {
            minv = root.left.info;
            root = root.left;
        }
        return minv;
    }

    Node min() {
        return minNode(root);
    }

    Node minNode(Node root) {
        if (root == null)
            return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    Node max() {
        return maxNode(root);
    }

    Node maxNode(Node root) {
        if (root == null)
            return null;
        while (root.right != null)
            root = root.right;
        return root;
    }

    int height(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    boolean isAVL(Node root) {
        if (root == null)
            return true;
        int balance = height(root.left) - height(root.right);
        return Math.abs(balance) <= 1 && isAVL(root.left) && isAVL(root.right);
    }

    int mystery(Node x) {
        if (x == null)
            return 0;
        return Math.max(mystery(x.left), mystery(x.right));
    }

    // 19) Determine whether a given binary tree is a heap.
    boolean isHeap(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.info.compareTo(root.info) > 0)
            return false;
        if (root.right != null && root.right.info.compareTo(root.info) > 0)
            return false;
        return isHeap(root.left) && isHeap(root.right);
    }

}