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

    public void visit(Node p) {
        if (p == null)
            return;
        System.out.print(p.info + " ");
    }

    // search for a node with value x
    public Node search(int x) {
        return search(root, x);
    }

    private Node search(Node p, int key) {
        if (p == null)
            return null;
        if (p.info == key)
            return p;
        else if (p.info > key)
            return search(p.left, key);
        else
            return search(p.right, key);
    }

    // insert a key x to the tree
    public void insert(int x) {
        Node p = new Node(x);
        Node f = null, q = root;
        while (q != null) {
            if (q.info == x) {
                System.out.println("Key cannot be duplicated...");
                return;
            }
            if (q.info < x) {
                f = q;
                q = q.right;
            } else {
                f = q;
                q = q.left;
            }
        }
        if (f == null)
            root = p;
        else if (p.info > f.info)
            f.right = p;
        else
            f.left = p;
    }

    // preorder a tree
    public void preOrder(Node p) {
        if (p == null)
            return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // postorder a tree
    public void postOrder(Node p) {
        if (p == null)
            return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    // inorder a tree
    public void inOrder(Node p) {
        if (p == null)
            return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    // bft
    public void BFT(Node p) {
        if (p == null)
            return;
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            visit(q);
            if (q.left != null)
                m.enqueue(q.left);
            if (q.right != null)
                m.enqueue(q.right);
        }
    }

    // count the number of nodes in the tree
    public int count() {
        return count(root);
    }

    private int count(Node p) {
        if (p == null)
            return 0;
        return 1 + count(p.left) + count(p.right);
    }

    // delete a node with value x
    public void dele(int x) {
        root = dele(root, x);
    }

    private Node dele(Node p, int x) {
        if (p == null)
            return null;
        if (x < p.info) {
            p.left = dele(p.left, x);
        } else if (x > p.info) {
            p.right = dele(p.right, x);
        } else {
            // Node with only one child or no child
            if (p.left == null)
                return p.right;
            else if (p.right == null)
                return p.left;

            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            p.info = min(p.right).info;
            p.right = dele(p.right, p.info);
        }
        return p;
    }

    // find the node with minimum value
    public Node min() {
        return min(root);
    }

    private Node min(Node p) {
        if (p.left == null)
            return p;
        return min(p.left);
    }

    // find the node with maximum value
    public Node max() {
        return max(root);
    }

    private Node max(Node p) {
        if (p.right == null)
            return p;
        return max(p.right);
    }

    // calculate the sum of all values in the tree
    public int sum() {
        return sum(root);
    }

    private int sum(Node p) {
        if (p == null)
            return 0;
        return p.info + sum(p.left) + sum(p.right);
    }

    // calculate the average of all values in the tree
    public double avg() {
        int total = sum();
        int count = count();
        return count == 0 ? 0 : (double) total / count;
    }

    // height of the tree
    public int height() {
        return height(root);
    }

    // cost of the most expensive path from root to leaf
    public int cost() {
        return cost(root);
    }

    private int cost(Node p) {
        if (p == null)
            return 0;
        return p.info + Math.max(cost(p.left), cost(p.right));
    }

    // check if the tree is AVL
    public boolean isAVL() {
        return isAVL(root);
    }

    private boolean isAVL(Node p) {
        // Implement AVL checking logic here
        return true; // Placeholder
    }

    // height of tree
    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);// compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth)
                return (lDepth + 1);// use the larger one
            else
                return (rDepth + 1);
        }
    }

    // breadth-first traversal of the tree
    public void breadth() {
        BFT(root);
    }

    // check if the tree is a heap
    public boolean isHeap() {
        return isHeap(root);
    }

    private boolean isHeap(Node p) {
        if (p == null)
            return true;
        if (p.left != null && p.left.info > p.info)
            return false;
        if (p.right != null && p.right.info > p.info)
            return false;
        return isHeap(p.left) && isHeap(p.right);
    }

    // mystery function
    public int mystery(Node x) {
        if (x == null)
            return 0;
        else
            return Math.max(mystery(x.left), mystery(x.right));
    }
}
