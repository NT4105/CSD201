
/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==========================================================================
import java.io.*;

class ItemList {
    ItemNode root;

    ItemList() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(ItemNode p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void postOrder(ItemNode p, RandomAccessFile f) throws Exception {
        if (p == null)
            return;
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadDataItem(int k) // do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

    ItemNode insertItem(ItemNode root, Item x) {
        if (root == null) {
            return new ItemNode(x);
        }

        int comp = x.getName().compareTo(root.info.getName());
        if (comp < 0) {
            root.left = insertItem(root.left, x);
        } else if (comp > 0) {
            root.right = insertItem(root.right, x);
        }
        return root;
    }

    void insert(String xName, int xQuantity, int xPrice) {
        Item newItem = new Item(xName, xQuantity, xPrice);
        this.root = insertItem(this.root, newItem);
    }
}

class OrderQueue {
    OrderNode front, rear;

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
        OrderNode node = new OrderNode(new Item(name, quantity));
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    Item deQueue() {
        if (isEmpty())
            return null;
        Item item = front.info;
        front = front.next;
        if (front == null)
            rear = null;
        return item;
    }
}

class OrderProcessing {
    ItemList iList = new ItemList();
    OrderQueue oQueue = new OrderQueue();

    OrderProcessing() {
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        f.writeBytes("Available items: ");
        iList.postOrder(iList.root, f);
        f.writeBytes("\r\n");
        f.writeBytes("Order list: ");
        OrderNode p = oQueue.front;
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

    // =============================================================================
    // ========YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART=========
    // =============================================================================

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

    void updateItemStock(ItemNode root, Item t) {
        if (root == null)
            return;

        int comp = t.getName().compareTo(root.info.getName());
        if (comp == 0) {
            // Found matching item
            if (root.info.getQuantity() >= t.getQuantity()) {
                root.info.setQuantity(root.info.getQuantity() - t.getQuantity());
            }
        } else if (comp < 0) {
            updateItemStock(root.left, t);
        } else {
            updateItemStock(root.right, t);
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

        Item t = oQueue.deQueue();
        if (t != null) {
            updateItemStock(iList.root, t);
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

        Item t;
        while ((t = oQueue.deQueue()) != null) {
            updateItemStock(iList.root, t);
        }

        ftraverse(f);
        f.close();
    }

    void ftraverse2(RandomAccessFile f) throws Exception {
        f.writeBytes("Available items: ");
        inOrderDesc(iList.root, f);
        f.writeBytes("\r\n");
        f.writeBytes("Order list: ");
        OrderNode p = oQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getName() + "," + p.info.getQuantity() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void inOrderDesc(ItemNode p, RandomAccessFile f) throws Exception {
        if (p == null)
            return;
        inOrderDesc(p.right, f);
        iList.fvisit(p, f);
        inOrderDesc(p.left, f);
    }

    int sumItemPrice(ItemNode root) {
        if (root == null)
            return 0;
        return root.info.getQuantity() * root.info.getPrice() +
                sumItemPrice(root.left) +
                sumItemPrice(root.right);
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
        int m = sumItemPrice(iList.root);

        Item t;
        while ((t = oQueue.deQueue()) != null) {
            updateItemStock(iList.root, t);
        }

        int n = sumItemPrice(iList.root);
        ftraverse2(f);
        f.writeBytes("Sales: " + (m - n));
        f.close();
    }
}
