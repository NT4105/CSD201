package lab2q2;

public class MyQueue {
    private Node front;
    private Node rear;

    public MyQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = null;
        rear = null;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        int value = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public int first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        return front.getData();
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public String decimalToBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "Please input a number between 0 and 1";
        }

        StringBuilder result = new StringBuilder("0.");
        MyQueue queue = new MyQueue();

        for (int i = 0; i < 10; i++) { // Convert up to 10 decimal places
            num = num * 2;
            int bit = (int) num;
            queue.enqueue(bit);
            if (num >= 1) {
                num = num - 1;
            }
        }

        while (!queue.isEmpty()) {
            try {
                result.append(queue.dequeue());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result.toString();
    }
}