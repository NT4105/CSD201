package q3;

public class Q3 {

    public static void main(String[] args) {
        MyList list = new MyList();

        // Test adding elements
        list.addToHead(5);
        list.addToHead(3);
        list.addToTail(7);
        list.addToTail(9);

        System.out.println("Initial list:");
        list.traverse(); // Should print: 3 5 7 9

        // Test adding after a node
        Node node = list.search(5);
        list.addAfter(node, 6);

        System.out.println("After adding 6 after 5:");
        list.traverse(); // Should print: 3 5 6 7 9

        // Test counting
        System.out.println("Number of nodes: " + list.count());

        // Test deletions
        System.out.println("Deleted from head: " + list.deleteFromHead());
        System.out.println("Deleted from tail: " + list.deleteFromTail());

        System.out.println("After deletions:");
        list.traverse();

        // Test delete specific value
        list.deleteNode(6);
        System.out.println("After deleting 6:");
        list.traverse();
    }

}
