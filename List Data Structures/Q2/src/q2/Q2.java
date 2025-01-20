package q2;

public class Q2 {

    public static void main(String[] args) {
        MyList list = new MyList();

        Node p = new Node();

        list.addToHead("Hanoi");
        list.addToHead("Saigon");
        list.addToTail("Danang");
        list.addToHead("Hue");
        list.addToTail("Cantho");
        list.addToHead("Nhatrang");
        list.addToTail("Dalat");
        list.addToHead("Haiphong");
        list.addToTail("Vungtau");
        list.addToHead("Halong");

        System.out.print("Created list: ");
        list.display();

        System.out.println("Number of nodes in the list: " + list.count());

        // Add a node with value x after the node p
        list.addAfter(p, "New York");
        System.out.print("List after adding a node with value New York after the node p: ");
        list.display();

        // Traverse from head to tail and display info of all nodes in the list
        System.out.print("Traverse from head to tail: ");
        list.traverse();
        System.out.println();

        // Count and return number of nodes in the list
        System.out.println("Number of nodes in the list: " + list.count());

        // Delete the first node in the list
        list.deleteHead();
        System.out.print("List after deleting the first node: ");
        list.display();

        // Delete the last node in the list
        list.deleteTail();
        System.out.print("List after deleting the last node: ");
        list.display();

        // Delete the node after the node p
        list.deleteAfter(p);
        System.out.print("List after deleting the node after the node p: ");
        list.display();

        // Delete the first node whose info is equal to x
        list.deleteNode("Hanoi");
        System.out.print("List after deleting the first node whose info is equal to Hanoi: ");
        list.display();

        // Search and return the reference to the first node having info x
        p = list.search("Hanoi");
        System.out.println("Reference to the first node having info Hanoi: " + p);
    }

}
