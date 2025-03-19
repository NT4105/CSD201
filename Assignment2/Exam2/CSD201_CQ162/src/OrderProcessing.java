
/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class ItemList {
    Node head, tail;

    ItemList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataItem(int k) // do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    void addLast(String name, int quantity, int price) {
        // You should write here appropriate statements to complete this function.
        // --------------------------------------------------------
        Item item = new Item(name, quantity, price);
        Node node = new Node(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        // ---------------------------------------------------------
    }
}

class OrderQueue {
    Node front, rear;

    OrderQueue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void clear() {
        front = rear = null;
    }

    void loadDataOrder(int k) // do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(String name, int quantity) {
        // You should write here appropriate statements to complete this function.
        // --------------------------------------------------------
        Node node = new Node(new Item(name, quantity));
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        // ---------------------------------------------------------
    }

    Item deQueue() {
        Item tmp = new Item();
        // You should write here appropriate statements to complete this function.
        // --------------------------------------------------------
        if (!isEmpty()) {
            tmp = front.info;
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
        // ---------------------------------------------------------
        return tmp;
    }
}

class OrderProcessing {
    ItemList iList = new ItemList();
    OrderQueue oQueue = new OrderQueue();

    OrderProcessing() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = iList.head;
        f.writeBytes("Available items: ");
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Order list: ");
        p = oQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getName() + "," + p.info.getQuantity() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception // do not edit this function
    {
        iList.loadDataItem(k);
        oQueue.loadDataOrder(k);
    }

    // ===========================================================================
    // =======YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
    // ===========================================================================
    void f1() throws Exception {
        load(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        f.close();
    }

    void purchase(Item t) throws Exception {
        // You should write here appropriate statements to complete this function.
        // --------------------------------------------------------
        Node current = iList.head;
        Node prev = null; // Thêm biến prev để theo dõi node trước đó

        // Search for item by name
        while (current != null) {
            if (current.info.getName().equals(t.getName())) {
                // Check if enough quantity available
                if (current.info.getQuantity() >= t.getQuantity()) {
                    // Update remaining quantity
                    current.info.setQuantity(current.info.getQuantity() - t.getQuantity());

                    // Remove node if quantity becomes 0
                    if (current.info.getQuantity() == 0) {
                        if (prev == null) {
                            iList.head = current.next;
                        } else {
                            prev.next = current.next;
                        }
                        if (current == iList.tail) {
                            iList.tail = prev;
                        }
                    }
                }
                break;
            }
            prev = current;
            current = current.next;
        }
    }

    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        Item t = oQueue.deQueue();
        if (t != null) {
            this.purchase(t);
        }

        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        while (!oQueue.isEmpty()) {
            Item t = oQueue.deQueue();
            if (t != null) {
                this.purchase(t);
            }
        }
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public int countNodes(Node head) {
        int count = 0;
        // You should write here appropriate statements to complete this function.
        // --------------------------------------------------------
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        // ---------------------------------------------------------
        return count;
    }

    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int count = 0;
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        while (!oQueue.isEmpty()) {
            Item t = oQueue.deQueue();
            if (t != null) {
                this.purchase(t);
            }
        }
        // ---------------------------------------------------------------------
        count = countNodes(iList.head);
        ftraverse(f);
        f.writeBytes("Items in stock: " + count + " ");
        f.close();
    }
}
