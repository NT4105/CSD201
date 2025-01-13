package q2;

public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    // 1. Add a node with value x at the head of a list
    public void addToHead(String x) {
        Node p = new Node(x);
        p.next = head;
        head = p;
        if (tail == null) {
            tail = p;
        }
    }

    // 2. Add a node with value x at the tail of a list
    public void addToTail(String x) {
        Node p = new Node(x);
        tail.next = p;
        tail = p;
    }

    // 3. add a node with value x after the node p
    public void addAfter(Node p, String x) {
        Node q = new Node(x);
        q.next = p.next;
        p.next = q;
    }

    // 4. Traverse from head to tail and display info of all nodes in the list
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
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

    // 6. Delete the head and return its info.
    public String deleteHead() {
        String x = head.info;
        head = head.next;
        return x;
    }

    // 7. Delete the tail and return its info.
    public String deleteTail() {
        String x = tail.info;
        tail = tail.next;
        return x;
    }

    // 8. Delete the node after the node p and return its info
    public String deleteAfter(Node p) {
        String x = p.next.info;
        p.next = p.next.next;
        return x;
    }

    // 9. Delete the first node whose info is equal to x.
    public void deleteNode(String x) {
        Node p = head;
        while (p != null) {
            if (p.info.equals(x)) {
                deleteAfter(p);
            }
            p = p.next;
        }
    }

    // 10. search and return the reference to the first node having info x.
    public Node search(String x) {
        Node p = head;
        while (p != null) {
            if (p.info.equals(x)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // Function display the list
    public void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }
}
