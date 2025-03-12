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
    
    public void preOrder(ItemNode p, RandomAccessFile f) throws Exception {       
        if(p == null) 
            return;
        fvisit(p,f);
        preOrder(p.left,f);
        preOrder(p.right,f);
    }
    
    void loadDataItem(int k) //do not edit this function
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
        //You should insert here statements to complete this function
        //---------------------------------------------------------------------
        
        //--------------------------------------------------------------------- 
        return root;
    }
    
    void insert(String xName, int xQuantity, int xPrice) {
        //You should insert here statements to complete this function
        //---------------------------------------------------------------------
        
//        this.root = insertItem(this.root, new Item(xName,xQuantity,xPrice)); 
        
	//---------------------------------------------------------------------       
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

    void loadDataOrder(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(String name, int quantity) {
        //You should insert here statements to complete this function
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
    }

    Item deQueue() {
        Item tmp = new Item();
        //You should write here statements to complete this function.
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        return tmp;
    }
}

class OrderProcessing {
    ItemList iList = new ItemList();
    OrderQueue oQueue = new OrderQueue();

    OrderProcessing() {
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        f.writeBytes("Available items: ");
        iList.preOrder(iList.root, f);
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

    void load(int k) throws Exception //do not edit this function
    {
        iList.loadDataItem(k);
        oQueue.loadDataOrder(k);
    }

//=============================================================================
//========YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART=========
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

    void updateItemStock(ItemNode root, Item t) { 
        //You should write here statements to complete this function.
        //---------------------------------------------------------------------
    
        //---------------------------------------------------------------------
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
        //---------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/   
        
//        Item t = oQueue.deQueue();
//        if (t != null) {
//            updateItemStock(iList.root, t);
//        }
        
        //---------------------------------------------------------------------
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
        //---------------------------------------------------------------------
        /*You must keep statements pre-given in this function. Your task is to 
        insert statements here, just after this comment, to complete the 
        question in the exam paper.*/ 

        //---------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    int countItem(ItemNode root) {
        //You should write here statements to complete this function.
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        return 0;
    }
    
    int sumItemPrice(ItemNode root) { 
        //You should write here statements to complete this function.
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        return 0;
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
        int s = 0, p = 0;
        //---------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        
        //---------------------------------------------------------------------
        s = countItem(iList.root);
        p = sumItemPrice(iList.root);       
        ftraverse(f);
        f.writeBytes("Number of Items: " + s);
        f.writeBytes("\nTotal value of items: " + p);   
        f.close();
    }
}
