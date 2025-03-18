/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==========================================================================
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

    void loadDataItem(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    // Add new item to the end of the list
    void addLast(String name, int quantity , int price) {
        Item item = new Item(name, quantity, price);
        Node node = new Node(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
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

    void loadDataOrder(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    // Add new order to the end of the queue
    void enQueue(String name, int quantity ) {
        Node node = new Node(new Item(name, quantity));
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    // Remove and return the first order from the queue
    Item deQueue() {
        Item tmp = null;
        if (!isEmpty()) {
            tmp = front.info;
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
        return tmp;
    }
}

class OrderProcessing {   
    ItemList iList  = new ItemList();
    OrderQueue oQueue = new OrderQueue();

    OrderProcessing() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = iList .head;
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
            f.writeBytes("(" + p.info.getName() + "," + p.info.getQuantity () + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        iList.loadDataItem(k);
        oQueue.loadDataOrder(k);
    }

//=============================================================================
//=========YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//=============================================================================
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

    // Check if the item can be purchased and update quantity
    int purchase(Item t) throws Exception {
        if (t == null) return 0;
        Node p = iList.head;
        while (p != null) {
            if (p.info.getName().equals(t.getName())) {
                if (p.info.getQuantity() >= t.getQuantity()) {
                    p.info.setQuantity(p.info.getQuantity() - t.getQuantity());
                    return 1;
                }
                return 0;
            }
            p = p.next;
        }
        return 0;
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
        
        // Process the first order
        Item t = oQueue.deQueue();
        if (t != null) {
            this.purchase(t);
        }
        
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
        
        // Process all orders in the queue
        while (!oQueue.isEmpty()) {
            Item t = oQueue.deQueue();
            if (t != null) {
                this.purchase(t);
            }
        }
        
        ftraverse(f);
        f.close();
    }
    
    // Sort items by price in ascending order
    public void sortList() {
        if (iList.head == null || iList.head.next == null) return;
        
        Node current = iList.head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.info.getPrice() < index.info.getPrice()) {
                    // Swap info
                    Item temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
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
        
        // Calculate total sales
        int totalSales = 0;
        Node[] originalQuantities = new Node[100];
        int count = 0;
        Node p = iList.head;
        while (p != null) {
            originalQuantities[count] = new Node(new Item(p.info.getName(), p.info.getQuantity(), p.info.getPrice()));
            count++;
            p = p.next;
        }
        
        while (!oQueue.isEmpty()) {
            Item t = oQueue.deQueue();
            if (t != null) {
                if (purchase(t) == 1) {
                    // Find original quantity to calculate sales
                    for (int i = 0; i < count; i++) {
                        if (originalQuantities[i].info.getName().equals(t.getName())) {
                            totalSales += t.getQuantity() * originalQuantities[i].info.getPrice();
                            break;
                        }
                    }
                }
            }
        }
        
        // Sort items by price in ascending order
        sortList();
        
        ftraverse(f);
        f.writeBytes("Sales: " + totalSales + "\r\n");
        f.close();
    }
}
