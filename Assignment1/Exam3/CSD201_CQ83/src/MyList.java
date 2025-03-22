import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
     * line k (for style),
     * line k+1 (for size), and
     * line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void addLast(String xStyle, int xSize, int xColor) {
        Node p = new Node(new Item(xStyle, xSize, xColor));
        if (p.getInfo().style.startsWith("B")) {
            return;
        } else {
            if (isEmpty()) {
                head = tail = p;
                size++;
            } else {
                tail.next = p;
                tail = p;
                size++;
            }
        }
    }

    void loadData1(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for (int i = 0; i < n; i++)
            addLast(a[i], b[i], c[i]);
    }

    void loadData2(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for (int i = 0; i < n; i++)
            addFirst(a[i], b[i], c[i]);
    }

    /**
     * Question 3.1: implement the 'addFirst' method that inserts a new Node
     * into the list's head.
     * The output of this method will be written into the file 'f1.txt'.
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of
     * 'f1.txt' after insertion should be:
     * (G,-3,2) (F,4,-7) (E,7,9) (D,2,4) (C,6,5) (B,5,3) (A,9,8)
     * 
     * @param xStyle the style of the input Item
     * @param xSize  the size of the input Item
     * @param xColor the color of the input Item
     */
    void addFirst(String xStyle, int xSize, int xColor) {
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        Node p = new Node(new Item(xStyle, xSize, xColor));
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
        size++;
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
    }

    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in the
     * linked list to file
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

    // This method is used for Question 3.2
    void f2() throws Exception {
        clear();
        loadData1(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        // Declare an Item Objects which will be used for the Question 2
        Item z;
        z = new Item("Z", 9, 12);

        /**
         * Question 3.2: use Item z declared above, write your code to insert the
         * node with info = z into the position that is after the first node that
         * has Item's style start with 'E'.
         * The output of this method will be written into the file 'f2.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before insertion is
         * (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
         * then the content of 'f2.txt' after insertion is
         * (C,9,8) (D,6,3) (E,8,5) (Z,9,12) (F,5,4) (I,4,9)
         */
        // -----------------------------------------------------------------------
        // ------ Start your code here--------------------------------------------
        Node p = head;
        while (p != null && !p.getInfo().style.startsWith("E")) {
            p = p.next;
        }
        if (p != null) {
            Node newNode = new Node(z);
            newNode.next = p.next;
            p.next = newNode;
        }
        size++;
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
        ftraverse(f); // write list's data to file
        f.close();
    }

    // This method is used for Question 3.3
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
         * Question 3.3: Find the first node in the linked list that has Item's size
         * lager than 8, if such a node is found, then set the color of Item in
         * this node to 99.
         * The output of this method will be written into the file 'f3.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before change is
         * (C,8,6) (D,3,5) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
         * then the content of 'f3.txt' after change is
         * (C,8,6) (D,3,5) (E,9,99) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
         */
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        Node p = head;
        while (p != null) {
            if (p.getInfo().size > 8) {
                p.getInfo().color = 99;
            }
            p = p.next;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 3.4
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
         * Question 3.4: delete the first node in the linked list with Item' size = 6.
         * The output of this method will be written into the file 'f4.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before deletion is:
         * (C,1,2) (D,10,3) (E,2,15) (F,11,6) (I,6,14) (J,11,15) (K,7,9)
         * then the content of 'f4.txt' after deletion is:
         * (C,1,2) (D,10,3) (E,2,15) (F,11,6) (J,11,15) (K,7,9)
         */
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.getInfo().size == 6) {
                if (prev == null) {
                    head = current.next; // nếu node cần xóa là head
                } else {
                    prev.next = current.next; // bỏ qua node hiện tại
                }
                break; // xóa node đầu tiên có size = 6 rồi thoát
            }
            prev = current;
            current = current.next;
        }
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void sortBySize() {
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        Node current = head;
        while (current != null) {
            Node next = current.next;
            while (next != null) {
                if (current.getInfo().size > next.getInfo().size) {
                    Item temp = current.getInfo();
                    current.setInfo(next.getInfo());
                    next.setInfo(temp);
                }
                next = next.next;
            }
            current = current.next;
        }
        // ------ End your code here------------------------------------------
        // -------------------------------------------------------------------
    }

    // This method is used for Question 1.4
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
         * Question 3.5: Sort the linked list in an ascending order according to
         * Item's size. Hint: Create a new method to sort the linked list, then
         * call the created method in f5().
         * The output of this method will be written into the file 'f5.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before sorting is:
         * (A,1,2) (E,2,15) (F,11,6) (I,6,14) (J,10,3) (K,7,9)
         * then the content of 'f5.txt' after sorting is:
         * (A,1,2) (E,2,15) (I,6,14) (K,7,9) (J,10,3) (F,11,6)
         */
        // -------------------------------------------------------------------
        // ------ Start your code here----------------------------------------
        // Hint: create a new method to sort the linked list, then call the
        // created method here
        sortBySize();
        // ------ End your code here------------------------------------------
        // ------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
