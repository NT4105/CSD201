package lab2q4;

public class Main {

    public static void main(String[] args) {
        // Testing Stack
        System.out.println("Testing Stack:");
        MyStack stack = new MyStack();

        stack.push('A');
        stack.push('B');
        stack.push('C');

        System.out.print("Stack contents: ");
        stack.traverse();

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());

        System.out.print("Stack after pop: ");
        stack.traverse();

        // Testing Queue
        System.out.println("\nTesting Queue:");
        MyQueue queue = new MyQueue();

        try {
            queue.enqueue('X');
            queue.enqueue('Y');
            queue.enqueue('Z');

            System.out.print("Queue contents: ");
            queue.traverse();

            System.out.println("First element: " + queue.first());
            System.out.println("Dequeued: " + queue.dequeue());

            System.out.print("Queue after dequeue: ");
            queue.traverse();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
