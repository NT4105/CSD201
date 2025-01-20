package q3;

public class MyList {
    Node head;
    Node tail;

    public MyList() {
        head = tail = null;
    }

    // 1. Add node at the head
    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.head = head;
            head.tail = newNode;
            head = newNode;
        }
    }

    // 2. Add node at the tail
    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.head = newNode;
            newNode.tail = tail;
            tail = newNode;
        }
    }

    // 3. Add node after a given node
    public void addAfter(Node p, int x) {
        if (p == null)
            return;

        Node newNode = new Node(x);
        newNode.head = p.head;
        newNode.tail = p;

        if (p.head != null) {
            p.head.tail = newNode;
        } else {
            tail = newNode;
        }
        p.head = newNode;
    }

    // 4. Traverse and display list
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.head;
        }
        System.out.println();
    }

    // 5. Count nodes
    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.head;
        }
        return count;
    }

    // 6. Delete from head
    public int deleteFromHead() {
        if (head == null)
            throw new RuntimeException("List is empty");

        int value = head.info;
        head = head.head;
        if (head != null) {
            head.tail = null;
        } else {
            tail = null;
        }
        return value;
    }

    // 7. Delete from tail
    public int deleteFromTail() {
        if (tail == null)
            throw new RuntimeException("List is empty");

        int value = tail.info;
        tail = tail.tail;
        if (tail != null) {
            tail.head = null;
        } else {
            head = null;
        }
        return value;
    }

    // 8. Delete after a given node
    public int deleteAfter(Node p) {
        if (p == null || p.head == null)
            throw new RuntimeException("Invalid operation");

        Node nodeToDelete = p.head;
        int value = nodeToDelete.info;

        p.head = nodeToDelete.head;
        if (nodeToDelete.head != null) {
            nodeToDelete.head.tail = p;
        } else {
            tail = p;
        }

        return value;
    }

    // 9. Delete node with given value
    public void deleteNode(int x) {
        Node current = head;

        while (current != null) {
            if (current.info == x) {
                if (current == head) {
                    deleteFromHead();
                } else if (current == tail) {
                    deleteFromTail();
                } else {
                    current.tail.head = current.head;
                    current.head.tail = current.tail;
                }
                return;
            }
            current = current.head;
        }
    }

    // 10. Search for node with given value
    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.info == x) {
                return current;
            }
            current = current.head;
        }
        return null;
    }
}
