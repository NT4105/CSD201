/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        // Example weighted graph based on Figure 1
        int[][] weightMatrix = {
            //a  b  c  d  e  f  g  h  i
            {0, 4, 0, 7, 0, 0, 0, 0, 0}, // a
            {4, 0, 3, 5, 0, 0, 0, 0, 0}, // b
            {0, 3, 0, 2, 0, 0, 0, 0, 0}, // c
            {7, 5, 2, 0, 0, 6, 0, 4, 0}, // d
            {0, 0, 0, 0, 0, 2, 0, 0, 0}, // e
            {0, 0, 0, 6, 2, 0, 0, 0, 0}, // f
            {0, 0, 0, 0, 0, 0, 0, 3, 2}, // g
            {0, 0, 0, 4, 0, 0, 3, 0, 0}, // h
            {0, 0, 0, 0, 0, 0, 2, 0, 0}  // i
        };
        
        WGraph g = new WGraph();
        g.setWeightMatrix(weightMatrix, 9);
        g.setLabel(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"});
        
        System.out.println("Finding Minimum Spanning Tree using Prim's algorithm:");
        g.primMST();
        
        System.out.println("\nFinding Minimum Spanning Tree using Kruskal's algorithm:");
        g.kruskalMST();
    }
}
