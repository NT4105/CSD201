package lab2q2;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test enqueue
        System.out.println("Enqueuing elements: 1, 2, 3, 4, 5");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Test traverse
        System.out.print("Queue elements: ");
        queue.traverse();

        try {
            // Test first
            System.out.println("First element: " + queue.first());

            // Test dequeue
            System.out.println("Dequeued element: " + queue.dequeue());
            System.out.print("Queue after dequeue: ");
            queue.traverse();

            // Test decimal to binary conversion
            double decimal = 0.625;
            System.out.println("\nConverting " + decimal + " to binary:");
            System.out.println(queue.decimalToBinary(decimal));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test clear
        System.out.println("\nClearing queue...");
        queue.clear();
        System.out.print("Queue after clearing: ");
        queue.traverse();

        // Test isEmpty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
