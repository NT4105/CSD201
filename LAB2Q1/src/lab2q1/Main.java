package lab2q1;

public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Test push and traverse
        System.out.println("Pushing elements: 5, 10, 15, 20");
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.traverse();

        // Test top
        System.out.println("Top element: " + stack.top());

        // Test pop
        System.out.println("Popped element: " + stack.pop());
        stack.traverse();

        // Test decimal to binary conversion
        int decimal = 25;
        System.out.println("\nConverting " + decimal + " to binary:");
        System.out.println("Binary: " + stack.decimalToBinary(decimal));

        // Test clear and isEmpty
        System.out.println("\nIs stack empty? " + stack.isEmpty());
        System.out.println("Clearing stack...");
        stack.clear();
        System.out.println("Is stack empty? " + stack.isEmpty());
    }

}
