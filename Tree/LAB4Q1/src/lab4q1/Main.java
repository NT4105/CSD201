/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4q1;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        // Insert values
        int[] values = { 60, 90, 80, 100, 50, 55, 40 };
        for (int value : values) {
            tree.insert(value);
        }

        // Check if tree is empty
        System.out.println("Is tree empty? " + tree.isEmpty());

        // Count nodes
        System.out.println("Number of nodes: " + tree.count());

        // Preorder traversal
        System.out.print("Preorder traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        // Inorder traversal
        System.out.print("Inorder traversal: ");
        tree.inOrder(tree.root);
        System.out.println();

        // Postorder traversal
        System.out.print("Postorder traversal: ");
        tree.postOrder(tree.root);
        System.out.println();

        // Find min and max
        System.out.println("Minimum value: " + tree.min().info);
        System.out.println("Maximum value: " + tree.max().info);

        // Calculate sum and average
        System.out.println("Sum of all values: " + tree.sum());
        System.out.println("Average of all values: " + tree.avg());

        // Height of the tree
        System.out.println("Height of the tree: " + tree.height());

        // Cost of the most expensive path
        System.out.println("Cost of the most expensive path: " + tree.cost());

        // Check if tree is AVL
        System.out.println("Is tree AVL? " + tree.isAVL());

        // Mystery function
        System.out.println("Mystery function result: " + tree.mystery(tree.root));

        // Check if tree is a heap
        System.out.println("Is tree a heap? " + tree.isHeap());

        // Delete a node
        tree.dele(90);
        System.out.print("Inorder traversal after deleting 90: ");
        tree.inOrder(tree.root);
        System.out.println();
    }

}
