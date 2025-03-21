import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    // default constructor
    public MyList() {head = tail = null;}
    
    // return true if Mylist is empty otherwise return false
    public boolean isEmpty() {return head == null;} 
    
    public void clear() {head = tail = null;}
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while(p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in the node p to the file f
            p = p.next;
        }
        
        f.writeBytes("\r\n");
    }
    
    /**
     *   Do NOT modify this method
     *   Load 3 lines of data from file: 
     *      line k (for location), 
     *      line k+1 (for price), and
     *      line k+2 (for area)
     *   @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for(int i = 0; i < n; i++) 
            addLast(a[i],b[i],c[i]);
    }
   
    /**
     *  Luy y: 
     *  1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh error khi 
     *  run chuong trinh.
     *  2. Neu khong tuan thu se nhan diem 0 (khong).
     * 
     *  Question 1.1: implement the 'addLast' method that inserts a new Node 
     *  into the list's tail if the attributes 'price' and 'area' of an 
     *  Office are positive (>0).
     *  The output of this method will be written into the file 'f1.txt'. 
     *  Therefore you should open this file to see/test your code output.
     *  Example: with the content given in the file 'data.txt', the content of 
     *  'f1.txt' after insertion should be:  
     *      (Q1,9,8) (Q2,5,3) (Q4,6,5) (Q9,1,1) (TD,7,9) (TB,4,7) (TD,3,2)   
     *  @param xLocation the location of the input Office
     *  @param xPrice the price (gia tien) of the input Office
     *  @param xArea the area (dien tich) of the input Office
     */
    void addLast(String xLocation, int xPrice, int xArea) {
        //---------------------------------------------------------------------
        //--------------- Start your code here---------------------------------       

        //---------------- End your code here----------------------------------
        //---------------------------------------------------------------------
    }
    
    /**
     *  Do NOT modify this method
     *  This is a helper method for writing data (node's info) stored in the 
     *  linked list to file @throws Exception 
     */
    
    // This method is used for Question 1.1
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        f.close();
    }
    
    // This method is used for Question 1.2
    void f2() throws Exception {
        clear();
        loadData(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
    /**
    * Question 1.2: Find the first node in the linked list where Office's 
    * location is 'TD', if such a node is found then set the price of Office 
    * in this node to 5. 
    * The output of this method will be written into the file 'f2.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before change is 
    *       (Q1,9,8) (Q2,5,3) (Q4,6,5) (Q9,1,1) (TD,7,9) (TB,4,7) (TD,3,2)   
    * then the content of 'f3.txt' after change is  
    *       (Q1,9,8) (Q2,5,3) (Q4,6,5) (Q9,1,1) (TD,5,9) (TB,4,7) (TD,3,2) 
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    // This method is used for Question 1.3
    void f3() throws Exception {
        clear();
        loadData(5);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     
    /**
      * Question 1.3: With all Offices in location "Q2", "Q9", or "TD", 
      * increase the price by 3.
      * The output of this method will be written into the file 'f3.txt'. 
      * Therefore you should open this file to see/test your code output.
      * Example: if the linked list before change is:           
      *     (Q1,9,8) (Q2,6,3) (Q4,8,5) (Q9,5,4) (TD,4,9)
      * then the content of 'f3.txt' after change is:  
      *     (Q1,9,8) (Q2,9,3) (Q4,8,5) (Q9,8,4) (TD,7,9)   
      * the changed nodes are: (Q2,6,3), (Q9,5,4), and (TD,4,9)
      */
        //---------------------------------------------------------------------
        //--------------- Start your code here--------------------------------- 

        //---------------- End your code here----------------------------------
        //---------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
     
    // This method is used for Question 1.4
    void f4() throws Exception {
        clear();
        loadData(9);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     
    /**
      * Question 1.4: Remove all Offices, except the largest Office? If 
      * there are more than one largest Office, keep the first of them.
      * The output of this method will be written into the file 'f4.txt'. 
      * Therefore you should open this file to see/test your code output.
      * Example: if the linked list is:            
      * (Q1,9,8) (Q2,5,3) (Q4,6,5) (Q9,1,1) (TD,7,9) (TB,4,7) (TD,3,2) (Q3,3,9)
      * then the content of 'f3.txt' is  (TD,7,9)  
      * The largest area is 9. There are two objects with this value: (TD,7,9) 
      * and (Q3,3,9); but we only find the first of them.
      */
        //---------------------------------------------------------------------
        //--------------- Start your code here---------------------------------

        //---------------- End your code here----------------------------------
        //---------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    // This method is used for Question 1.5
    void f5() throws Exception {
        clear();
        loadData(13);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    /**
      * Question 1.5: Sort the linked list in an descending order according to 
      * Office's price.
      * The output of this method will be written into the file 'f5.txt'. 
      * Therefore you should open this file to see/test your code output.
      * Example: if the linked list before sorting is:           
      * (Q1,9,8) (Q2,5,3) (Q4,6,5) (Q9,1,1) (TD,7,9) (TB,4,7) (TD,2,2) (Q3,3,9)
      * then the content of 'f4.txt' after sorting is:  
      * (Q1,9,8) (TD,7,9) (Q4,6,5) (Q2,5,3) (TB,4,7) (Q3,3,9) (TD,2,2) (Q9,1,1)
      */
        //---------------------------------------------------------------------
        //--------------- Start your code here---------------------------------
//        sortList();
        //---------------- End your code here----------------------------------
        //---------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
//    public void sortList() {
//
//    }
    
}

