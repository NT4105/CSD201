/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4q2;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert("Apple");
        bst.insert("Banana");
        bst.insert("Cherry");
        bst.insert("Date");
        bst.insert("Fig");

        System.out.println("Is tree emty? " + bst.isEmpty());
        
        System.out.println("Number of nodes: " + bst.count(bst.root));

        System.out.println("Tree Breadth Traversal:");
        bst.breadth();

        System.out.println("Tree Preorder Traversal:");
        bst.preorder(bst.root);

        System.out.println("\nIs the tree AVL? " + bst.isAVL(bst.root));

        // Example of searching for a node
        String searchKey = "Cherry";
        Node foundNode = bst.search(searchKey);
        System.out.print("Search for " + searchKey + ": " + (foundNode != null ? "Found" : "Not Found"));

        // Example of deleting a node
        String deleteKey = "Banana";
        bst.delete(deleteKey);
        System.out.println("After deleting " + deleteKey + ":");
        bst.breadth();
    }

}
