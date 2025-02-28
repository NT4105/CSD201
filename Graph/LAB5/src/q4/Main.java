
package q4;

public class Main {
    public static void main(String[] args) {
        // Adjacency matrix from Figure 1
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
        
        // Color the graph
        g.colorGraph();
        
        // Print results
        g.printColoring();
        
        // Verify if coloring is valid
        System.out.println("\nIs coloring valid? " + g.isValidColoring());
    }
}
