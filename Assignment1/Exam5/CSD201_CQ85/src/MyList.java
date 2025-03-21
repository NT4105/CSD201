import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;

    // default constructor
    public MyList() {
        head = tail = null;
    }

    // return true if Mylist is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        // write data in the node p to the file f
        while (p != null) {
            f.writeBytes(p.getInfo() + " ");
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    /**
     * Do NOT modify this method
     * Load 3 lines of data from file:
     * line k (for owner),
     * line k+1 (for price), and
     * line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void addFirst(String xOwner, int xPrice, int xColor) {
        Node p = new Node(new Car(xOwner, xPrice, xColor));
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    void loadData1(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for (int i = 0; i < n; i++)
            addFirst(a[i], b[i], c[i]);
    }

    void loadData2(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for (int i = 0; i < n; i++)
            addLast(a[i], b[i], c[i]);
    }

    /**
     * Question 5.1: implement the 'addLast' method that inserts a new Node
     * into the list's tail if the attribute 'owner' of a Car does NOT
     * start with 'D'.
     * The output of this method will be written into the file 'f1.txt'.
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of
     * 'f1.txt' after insertion should be:
     * (A,9,8) (B,5,3) (C,6,5) (E,7,9) (F,4,-7) (G,-3,2)
     * 
     * @param xOwner the owner of the input Car
     * @param xPrice the price of the input Car
     * @param xColor the color of the input Car
     */
    void addLast(String xOwner, int xPrice, int xColor) {
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        if (!xOwner.startsWith("D")) {
            Car car = new Car(xOwner, xPrice, xColor);
            Node node = new Node(car);
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
    }

    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in
     * the linked list to file
     * 
     * @throws Exception
     */
    void f1() throws Exception {
        clear();
        loadData2(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 5.2
    void f2() throws Exception {
        clear();
        loadData1(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        // Declare two Car Objects which will be used for the Question 2
        Car x, y;
        x = new Car("X", 5, 7);
        y = new Car("Y", 4, 6);

        /**
         * Question 5.2: use Car x and Car y declared above, write your code to:
         * (1) insert the node with info = x into the second position
         * of the list, and
         * (2) insert the node with info = y into the fourth position
         * of the list.
         * The output of this method will be written into the file 'f2.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before insertion is:
         * (I,4,9) (F,5,4) (E,8,5) (B,6,3) (A,9,8)
         * then the content of 'f2.txt' after insertion is:
         * (I,4,9) (X,5,7) (F,5,4) (Y,4,6) (E,8,5) (B,6,3) (A,9,8)
         */
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        // Insert x at second position
        Node p = new Node(x);
        if (head != null) {
            p.next = head.next;
            head.next = p;
        }

        // Insert y at fourth position
        Node q = new Node(y);
        Node current = head;
        for (int i = 0; i < 2; i++) {
            if (current != null)
                current = current.next;
        }
        if (current != null) {
            q.next = current.next;
            current.next = q;
        }
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
        ftraverse(f); // write list's data to file
        f.close();
    }

    // This method is used for Question 5.3
    void f3() throws Exception {
        clear();
        loadData1(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        /**
         * Question 5.3: Find the first node in the linked list that has Car's price
         * less than 6, if such a node is found, then set the color of Car in this
         * node to 55.
         * The output of this method will be written into the file 'f3.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before change is
         * (I,7,3) (H,6,8) (G,9,7) (F,5,8) (E,9,2) (B,3,5) (A,8,6)
         * then the content of 'f3.txt' after change is
         * (I,7,3) (H,6,8) (G,9,7) (F,5,55) (E,9,2) (B,3,5) (A,8,6)
         */
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        Node current = head;
        while (current != null) {
            if (current.getInfo().price < 6) {
                current.getInfo().color = 55;
            }
            current = current.next;
        }
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 5.4
    void f4() throws Exception {
        clear();
        loadData1(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        /**
         * Question 5.4: Delete the node holding the most expensive Car
         * (maximum price).If there is more than one node that satisfies the
         * requirement, delete the last one of them.
         * Hint:
         * - Find the Maximum Value: Traverse the list to identify the largest
         * value and track its last occurrence.
         * - Delete the Last Occurrence: Adjust the next pointer of the previous
         * node to bypass the max node.
         * The output of this method will be written to file 'f4.txt'.
         * Therefore you should open this file to see/test your code output.
         * The output of the file 'f5.txt' after saving the result is:
         * (K,7,9) (J,11,15) (I,6,14) (F,11,6) (E,2,15) (B,10,3) (A,1,2)
         * (K,7,9) (J,11,15) (I,6,14) (E,2,15) (B,10,3) (A,1,2)
         */
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        Node current = head;
        Node maxNode = head;
        while (current != null) {
            if (current.getInfo().price > maxNode.getInfo().price) {
                maxNode = current;
            }
            current = current.next;
        }
        Node prev = null;
        current = head;
        while (current != null) {
            if (current == maxNode) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                break;
            }
            prev = current;
            current = current.next;
        }
        // Find the maximum value and its last occurrence
        // Node prev = null, maxPrev = null, maxNode = head;
        // int maxVal = head.getInfo().price;
        // Node current = head;
        // while (current.next != null) {
        // ...
        // }

        // Delete maxNode by skipping it

        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 5.5
    void f5() throws Exception {
        clear();
        loadData1(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        /**
         * Question 5.5: How many Cars are there in the list?.
         * Hint: You should use f.writeBytes( … ) to write the result to the output
         * file.
         * The output of this method will be written to file 'f5.txt'.
         * Therefore you should open this file to see/test your code output.
         * The output of the file 'f5.txt' after saving the result is:
         * (L,6,8) (K,5,6) (F,-3,9) (J,4,5) (I,3,7) (H,1,3) (G,2,-2)
         * 7
         */
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        f.writeBytes(count + "");
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
        // ftraverse(f);
        f.close();
    }
}
