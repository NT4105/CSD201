
/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==========================================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { // do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

    Node insertRec(Node p, Cat x) {
        // You should insert here statements to complete this function
        // ---------------------------------------------------------------------
        if (p == null) {
            return new Node(x);
        }
        if (x.weight < p.info.weight) {
            p.left = insertRec(p.left, x);
        } else if (x.weight > p.info.weight) {
            p.right = insertRec(p.right, x);
        }
        return p;

        // ---------------------------------------------------------------------
    }

    // =============================================================================
    // (2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
    // =============================================================================
    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh
     * error khi run chuong trinh.
     * 2. Neu khong tuan thu se nhan diem 0 (khong).
     * Question 4.1: use Cat’s weight as the key attribute when building a BST.
     * Implement the 'insert' method so that any node with xPlace.charAt(0)=='F'
     * is not inserted to the tree.
     * The output of this method will be written into the file 'f1.txt'.
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of
     * 'f1.txt' after insertion should be:
     * (X,5,2) (N,3,6) (M,9,5) (P,1,3) (R,4,8) (Q,8,7)
     * (P,1,3) (N,3,6) (R,4,8) (X,5,2) (Q,8,7) (M,9,5)
     * 
     * @param xPlace  the place of the input Cat
     * @param xWeight the weight of the input Cat
     * @param xColor  the color of the input Cat
     */
    void insert(String xPlace, int xWeight, int xColor) {
        // You should insert here statements to complete this function
        // ---------------------------------------------------------------------
        if (!(xPlace.charAt(0) == 'F')) {
            this.root = insertRec(this.root, new Cat(xPlace, xWeight, xColor));
        }

        // ---------------------------------------------------------------------
    }

    int countInternalNodes(Node p, int count) {
        if (p == null) {
            return count;
        }
        if (p.left != null || p.right != null) {
            count++;
        }
        count = countInternalNodes(p.left, count);
        count = countInternalNodes(p.right, count);
        return count;
    }

    // Do not edit this function.
    // Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    // =============================================================================

    public void preOrder2(Node p, RandomAccessFile f) throws Exception {
        // You should insert here statements to complete this function
        // ---------------------------------------------------------------------
        if (p == null) {
            return;
        }
        if (p.info.color < 8) {
            fvisit(p, f);
        }
        preOrder2(p.right, f);
        // ---------------------------------------------------------------------
    }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        /**
         * Question 4.2: Perform the pre-order traversal for the right branch of
         * BST, but ONLY visit nodes that has Cat's color less than to 8.
         * Hint: This method is similar to the method 'preOrder' (provided in this
         * class already). You should create a new method which body is similar to
         * 'preOrder' for doing the pre-order traversal but considering only nodes
         * on the right branch of BST with color less than to 8.
         * The output f2() will be written into the file 'f2.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f2.txt'
         * after running this method is:
         * (P,7,9) (D,4,3) (G,9,6) (H,2,5) (B,6,4) (X,8,9) (L,1,8) (N,3,1)
         * (G,9,6)
         */
        // ---------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        preOrder2(root, f);

        // ---------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    // =============================================================================

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        // You should insert here statements to complete this function
        // ---------------------------------------------------------------------
        if (p == null) {
            return;
        }
        inOrder2(p.right, f);
        if (p.info.weight > 2) {
            fvisit(p, f);
        }
        inOrder2(p.left, f);
        // ---------------------------------------------------------------------
    }

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        /**
         * Question 4.3: Perform a new traversal method to visit all nodes in the
         * BST with the constraint: visit the nodes with weight>2 and in the
         * descending order of weight.
         * Hint: This method is similar to the method 'inOrder' (provided in this
         * class already). You should create a new method which body is similar to
         * 'inOrder' but only visits the nodes with weight>2 and in the descending
         * order of weight.
         * The output f3() will be written into the file 'f3.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f3.txt'
         * after running this method is:
         * (T,8,-5) (M,7,2) (P,6,3) (R,5,9) (S,4,1)
         */
        // ---------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        inOrder2(root, f);

        // ---------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    // =============================================================

    void printLeafNodes(Node p, RandomAccessFile f) throws Exception {
        // You should insert here statements to complete this function
        // ---------------------------------------------------------------------
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            fvisit(p, f);
        }
        printLeafNodes(p.left, f);
        printLeafNodes(p.right, f);
        // ---------------------------------------------------------------------
    }

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        /**
         * Question 4.4: Print out leaf nodes of the tree.
         * Hint: Leaf nodes have neither left child nor right child.
         * The output f4() will be written into the file 'f4.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f4.txt'
         * after running this method is:
         * (A,6,5) (B,2,7) (P,1,9) (C,3,-8) (D,5,-3) (E,8,3) (G,7,4) (Q,9,1)
         * (P,1,9) (D,5,-3) (G,7,4) (Q,9,1)
         * //---------------------------------------------------------------------
         * /*You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        printLeafNodes(root, f);

        // ---------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    // =============================================================================

    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        /**
         * Question 4.5: How many internal nodes are there in the BST?.
         * Hint: A node with no children is called a leaf of the tree; all
         * non-leaves are called internal nodes.
         * The output f5() will be written into the file 'f5.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f5.txt'
         * after running this method is:
         * (L,1,5) (H,2,6) (Q,3,1) (D,4,3) (B,6,-4) (M,7,9) (X,8,7) (G,9,-6)
         * 4
         */
        // ---------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        int count = 0;
        count = countInternalNodes(root, count);
        f.writeBytes(count + "");

        // ---------------------------------------------------------------------
        f.close();
    }

}
