package lab2q1;

import java.util.EmptyStackException;

public class MyStack {
    private Node top;

    public MyStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.setNext(top);
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.getData();
        top = top.getNext();
        return value;
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    public void traverse() {
        Node current = top;
        System.out.print("Stack (top to bottom): ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public String decimalToBinary(int decimal) {
        if (decimal == 0)
            return "0";

        MyStack stack = new MyStack();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }
        return binary.toString();
    }
}
