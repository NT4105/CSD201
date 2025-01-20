package q1;

public class Q1 {

    public static void main(String[] args) {
        Node p = new Node();
        MyList list = new MyList();

        list.addToHead(6);
        list.addToHead(4);
        list.addToTail(5);
        list.addToHead(7);
        list.addToTail(3);
        list.addToHead(1);
        list.addToTail(3);
        list.addToHead(5);
        System.out.print("Created list: ");
        list.display();

        int count = list.size();

        System.out.println("Numbers of nodes in the list: " + count);

        // Add a node with value x after the node p
        list.addAfter(p, 10);
        System.out.print("List after adding a node with value 10 after the node p: ");
        list.display();

        // Traverse from head to tail and display info of all nodes in the list
        System.out.print("Traverse from head to tail: ");
        list.traverse();
        System.out.println();

        // Count and return number of nodes in the list
        System.out.println("Numbers of nodes in the list: " + count);

        // Delete the head and return its info
        int x = list.deleteFromHead();
        System.out.println("Deleted node with value: " + x);
        System.out.print("List after deleting the head: ");
        list.display();

        // Delete the tail and return its info
        x = list.deleteFromTail();
        System.out.println("Deleted node with value: " + x);
        System.out.print("List after deleting the tail: ");
        list.display();

        // Delete the node after the node p and return its info
        x = list.deleteAfter(p);
        System.out.println("Deleted node with value: " + x);
        System.out.print("List after deleting the node after the node p: ");
        list.display();
    }

}
