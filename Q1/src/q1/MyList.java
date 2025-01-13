package q1;

public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // 1. Insert a node with value x at head of the list
    public void addToHead(int x) {
        Node p = new Node(x);
        p.next = head;
        head = p;
        if (tail == null) {
            tail = p;
        }
    }

    // 2. Insert a node with value x at the tail of the list
    public void addToTail(int x) {
        Node p = new Node(x);
        tail.next = p;
        tail = p;
    }

    // 3. Add a node with a value x after the node p
    public void addAfter(Node p, int x) {
        Node q = new Node(x);
        q.next = p.next;
        p.next = q;
        if (p == tail) {
            tail = q;
        }
    }

    // 4. Traverse from head to tail and dislay info of all nodes in the list
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    // 5. Count and return number of nodes in the list
    public int count() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // 6. Delete the head and return its info
    public int deleteFromHead() {
        if (head == null) {
            return -1;
        }
        int x = head.info;
        head = head.next;
        return x;
    }

    // 7. Delete the tail and return its info
    public int deleteFromTail() {
        if (head == null) {
            return -1;
        }
        int x = tail.info;
        Node p = head;
        while (p.next != tail) {
            p = p.next;
        }
        p.next = null;
        tail = p;
        return x;
    }

    // 8. Delete the node after the node p and return its info
    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            return -1;
        }
        int x = p.next.info;
        p.next = p.next.next;
        return x;
    }

    // 9. Delete the first node whose info is equal to x
    public void deleteNode(int x) {
        Node p = head;
        while (p != null && p.info != x) {
            p = p.next;
        }
        deleteAfter(p);
    }

    // 10. search and return the reference to the first node having info x
    public Node search(int x) {
        Node p = head;
        while (p != null && p.info != x) {
            p = p.next;
        }
        return p;
    }

    // 11. delete node p if it exists in the list
    public void delete(Node p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            deleteFromHead();
        } else if (p == tail) {
            deleteFromTail();
        } else {
            deleteAfter(p);
        }
    }

    // 12. delete an i-th node on the list. Be sure that such a node exists.
    public void deleteIth(int i) {
        Node p = head;
        for (int j = 1; j < i; j++) {
            p = p.next;
        }
        delete(p);
    }

    // 13. add a node with value x before the node p.
    public void addBefore(Node p, int x) {
        Node q = new Node(x);
        q.next = p;
        p.next = q;
    }

    // 14. sort the list in ascending order of info
    public void sort() {
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.info > q.info) {
                    int temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
                q = q.next;
            }
        }
    }

    // 15. Reverse a singly linked list using only one pass through the list
    public void reverse() {
        Node p = head;
        Node q = null;
        while (p != null) {
            Node temp = p.next;
            p.next = q;
            q = p;
            p = temp;
        }
        head = q;
    }

    // 16. create and return array containing info of all nodes in the list
    public int[] toArray() {
        int[] arr = new int[size()];
        Node p = head;
        for (int i = 0; i < size(); i++) {
            arr[i] = p.info;
            p = p.next;
        }
        return arr;
    }

    // 17. Merge two ordered singly linked lists of integers into one ordered list.
    public void merge(MyList list1, MyList list2) {
        Node p = list1.head;
        Node q = list2.head;
        while (p != null && q != null) {
            if (p.info < q.info) {
                addToTail(p.info);
                p = p.next;
            } else {
                addToTail(q.info);
                q = q.next;
            }
        }
    }

    // 18. Attach a singly linked list to the end of another singly linked list.
    public void attach(MyList list) {
        tail.next = list.head;
        tail = list.tail;
    }

    // 19. Find and return the maximum value in the list.
    public int max() {
        Node p = head;
        int max = p.info;
        while (p != null) {
            if (p.info > max) {
                max = p.info;
            }
            p = p.next;
        }
        return max;
    }

    // 20. Find and return the minimum value in the list
    public int min() {
        Node p = head;
        int min = p.info;
        while (p != null) {
            if (p.info < min) {
                min = p.info;
            }
            p = p.next;
        }
        return min;
    }

    // 21. Return the sum of all values in the list.
    public int sum() {
        Node p = head;
        int sum = 0;
        while (p != null) {
            sum += p.info;
            p = p.next;
        }
        return sum;
    }

    // 22. Return the average of all values in the list.
    public double average() {
        return sum() / size();
    }

    // 23. Check and return true if the list is sorted, return false if the list is
    // not sorted.
    public boolean isSorted() {
        Node p = head;
        while (p != null && p.next != null) {
            if (p.info > p.next.info) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    // 24. Insert node with value x into sorted list so that the new list is sorted
    public void insert(int x) {
        Node p = head;
        while (p != null && p.info < x) {
            p = p.next;
        }
        addBefore(p, x);
    }

    // 25. Check whether two singly linked list have the same contents.
    public boolean same(MyList list) {
        Node p = head;
        Node q = list.head;
        while (p != null && q != null) {
            if (p.info != q.info) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    // Function display the list
    public void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }
}
