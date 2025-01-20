package lab2q4;

import java.util.EmptyStackException;

public class MyStack {
    private Node head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void push(char x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        char value = head.info;
        head = head.next;
        return value;
    }

    public char top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.info;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }
}