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
        int[] x = { 60, 90, 80, 100, 50, 55, 40 };
        BSTree tree = new BSTree();
        for (int i = 0; i < x.length; i++)
            tree.insert(x[i]);
        tree.preOrder(tree.root);// 60 50 40 55 90 80 100
        System.out.println("");
        tree.inOrder(tree.root);// 40 50 55 60 80 90 100
        System.out.println("");
        tree.BFT(tree.root);
        System.out.println("");
    }

}
