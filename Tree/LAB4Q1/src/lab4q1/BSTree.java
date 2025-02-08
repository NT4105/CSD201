/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4q1;

/**
 *
 * @author ACER
 */
public class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node search(int x) {
        return searchRec(root, x);
    }

    private Node searchRec(Node root, int x) {
        if (root == null || root.info == x) {
            return root;
        }
        return x < root.info ? searchRec(root.left, x) : searchRec(root.right, x);
    }

    public void insert(int x) {
        if (search(x) == null) {
            root = insertRec(root, x);
        }
    }

    private Node insertRec(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (x < root.info) {
            root.left = insertRec(root.left, x);
        } else {
            root.right = insertRec(root.right, x);
        }
        return root;
    }

    public void breadth() {
        MyQueue queue = new MyQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node current = (Node) queue.dequeue();
            if (current != null) {
                System.out.print(current.info + " ");
                queue.enqueue(current.left);
                queue.enqueue(current.right);
            }
        }
    }

    public void preOrder(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.info + " ");
            inorder(p.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.info + " ");
        }
    }

    public int count() {
        return countRec(root);
    }

    private int countRec(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + countRec(p.left) + countRec(p.right);
    }

    public void dele(int x) {
        root = deleRec(root, x);
    }

    private Node deleRec(Node root, int x) {
        if (root == null)
            return root;
        if (x < root.info) {
            root.left = deleRec(root.left, x);
        } else if (x > root.info) {
            root.right = deleRec(root.right, x);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.info = min().info;
            root.right = deleRec(root.right, root.info);
        }
        return root;
    }

    public Node min() {
        return minRec(root);
    }

    private Node minRec(Node root) {
        return root.left == null ? root : minRec(root.left);
    }

    public Node max() {
        return maxRec(root);
    }

    private Node maxRec(Node root) {
        return root.right == null ? root : maxRec(root.right);
    }

    public int sum() {
        return sumRec(root);
    }

    private int sumRec(Node p) {
        if (p == null)
            return 0;
        return p.info + sumRec(p.left) + sumRec(p.right);
    }

    public int avg() {
        int total = sum();
        int count = count();
        return count == 0 ? 0 : total / count;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node p) {
        if (p == null)
            return -1;
        return 1 + Math.max(heightRec(p.left), heightRec(p.right));
    }

    public int maxPathCost() {
        return maxPathCostRec(root);
    }

    private int maxPathCostRec(Node p) {
        if (p == null)
            return 0;
        return p.info + Math.max(maxPathCostRec(p.left), maxPathCostRec(p.right));
    }

    public boolean isAVL() {
        return isAVLRec(root) != -1;
    }

    private int isAVLRec(Node node) {
        if (node == null)
            return 0;
        int leftHeight = isAVLRec(node.left);
        int rightHeight = isAVLRec(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isHeap() {
        return isHeapRec(root);
    }

    private boolean isHeapRec(Node node) {
        // Implement heap check logic
        return true; // Placeholder
    }
}
