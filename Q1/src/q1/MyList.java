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

}
