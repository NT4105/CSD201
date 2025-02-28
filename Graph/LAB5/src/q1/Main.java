/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        // Create adjacency matrix for the graph in Figure 1
        int[][] matrix = {
            //a  b  c  d  e  f  g  h  i
            {0, 1, 0, 1, 0, 0, 0, 0, 0}, // a
            {1, 0, 1, 1, 0, 0, 0, 0, 0}, // b
            {0, 1, 0, 1, 0, 0, 0, 0, 0}, // c
            {1, 1, 1, 0, 0, 1, 0, 1, 0}, // d
            {0, 0, 0, 0, 0, 1, 0, 0, 0}, // e
            {0, 0, 0, 1, 1, 0, 0, 0, 0}, // f
            {0, 0, 0, 0, 0, 0, 0, 1, 1}, // g
            {0, 0, 0, 1, 0, 0, 1, 0, 0}, // h
            {0, 0, 0, 0, 0, 0, 1, 0, 0}  // i
        };
        
        Graph g = new Graph();
        g.setAMatrix(matrix, 9);
        g.setLabel(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"});
        
        System.out.println("BFS starting from vertex a:");
        g.BFS(0);
        System.out.println("\nDFS starting from vertex a:");
        g.DFS(0);
    }
}
