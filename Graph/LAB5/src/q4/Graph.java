// Graph Coloring using the Sequential Coloring algorithm:
package q4;


public class Graph {
    private int[][] a;      // adjacency matrix
    private String[] label; // vertex labels
    private int n;         // number of vertices
    private int[] colors;  // array to store colors (1,2,3,...)
    
    public Graph() {
        n = 0;
        a = null;
        label = null;
        colors = null;
    }
    
    public void setAMatrix(int[][] b, int m) {
        n = m;
        a = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                a[i][j] = b[i][j];
        colors = new int[n];
    }
    
    public void setLabel(String[] c) {
        label = new String[n];
        for(int i = 0; i < n; i++)
            label[i] = c[i];
    }
    
    // Sequential Coloring Algorithm
    public void colorGraph() {
        // Initialize all vertices with color 0 (uncolored)
        for(int i = 0; i < n; i++) {
            colors[i] = 0;
        }
        
        // Boolean array for available colors
        boolean[] available = new boolean[n];
        
        // Initially all colors are available
        for(int i = 0; i < n; i++) {
            available[i] = true;
        }
        
        // Assign first color to first vertex
        colors[0] = 1;
        
        // Assign colors to remaining vertices
        for(int u = 1; u < n; u++) {
            // Process all adjacent vertices and mark their colors as unavailable
            for(int i = 0; i < n; i++) {
                if(a[u][i] == 1 && colors[i] != 0) {
                    available[colors[i] - 1] = false;
                }
            }
            
            // Find the first available color
            int cr;
            for(cr = 0; cr < n; cr++) {
                if(available[cr]) {
                    break;
                }
            }
            
            // Assign the found color
            colors[u] = cr + 1;
            
            // Reset the available array for next iteration
            for(int i = 0; i < n; i++) {
                available[i] = true;
            }
        }
    }
    
    // Method to get the chromatic number (maximum color used)
    public int getChromaticNumber() {
        int maxColor = 0;
        for(int i = 0; i < n; i++) {
            if(colors[i] > maxColor) {
                maxColor = colors[i];
            }
        }
        return maxColor;
    }
    
    // Method to print the coloring result
    public void printColoring() {
        System.out.println("Vertex Coloring Results:");
        System.out.println("Vertex\tColor");
        for(int i = 0; i < n; i++) {
            System.out.println(label[i] + "\t" + getColorName(colors[i]));
        }
        System.out.println("\nChromatic Number: " + getChromaticNumber());
    }
    
    // Helper method to convert color numbers to color names
    private String getColorName(int color) {
        switch(color) {
            case 1: return "Red";
            case 2: return "Blue";
            case 3: return "Green";
            case 4: return "Yellow";
            case 5: return "Purple";
            case 6: return "Orange";
            case 7: return "Pink";
            case 8: return "Brown";
            case 9: return "Gray";
            default: return "Color-" + color;
        }
    }
    
    // Method to verify if the coloring is valid
    public boolean isValidColoring() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1 && colors[i] == colors[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
