package lab2q4;

public class MyQueue {
    private Node front, rear;

    public MyQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = rear = null;
    }

    public void enqueue(char x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public char dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        char value = front.info;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public char first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return front.info;
    }

    public void traverse() {
        Node current = front;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }
}
