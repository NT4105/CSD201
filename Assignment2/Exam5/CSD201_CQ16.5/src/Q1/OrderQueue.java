public class OrderQueue {
    private OrderNode front, rear;

    public OrderQueue() {
        front = null;
        rear = null;
    }

    // f1: Enqueue an order
    public void enQueue(String itemName, int quantity) {
        OrderNode newNode = new OrderNode(itemName, quantity);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.setNext(newNode);
        rear = newNode;
    }

    // Display all orders in the queue
    public void display() {
        if (front == null) {
            System.out.println("Order list: Empty");
            return;
        }

        System.out.print("Order list: ");
        OrderNode current = front;
        while (current != null) {
            System.out.print(current + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}