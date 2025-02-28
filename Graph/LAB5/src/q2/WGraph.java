// Dijkstra's algorithm:
package q2;


public class WGraph {
    private int[][] weight; // weighted adjacency matrix
    private String[] label;
    private int n;
    private final int INF = 999999; // represent infinity
    
    public WGraph() {
        n = 0;
        weight = null;
        label = null;
    }
    
    public void setWeightMatrix(int[][] w, int size) {
        n = size;
        weight = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                weight[i][j] = w[i][j];
    }
    
    public void setLabel(String[] labels) {
        label = new String[n];
        for(int i = 0; i < n; i++)
            label[i] = labels[i];
    }
    
    public void dijkstra(int start) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        int[] previous = new int[n];
        
        // Initialize distances
        for(int i = 0; i < n; i++) {
            distance[i] = INF;
            visited[i] = false;
            previous[i] = -1;
        }
        distance[start] = 0;
        
        for(int count = 0; count < n-1; count++) {
            // Find vertex with minimum distance
            int u = minDistance(distance, visited);
            visited[u] = true;
            
            // Update distances of adjacent vertices
            for(int v = 0; v < n; v++) {
                if(!visited[v] && weight[u][v] != 0 && 
                   distance[u] != INF && 
                   distance[u] + weight[u][v] < distance[v]) {
                    distance[v] = distance[u] + weight[u][v];
                    previous[v] = u;
                }
            }
        }
        
        // Print results
        printSolution(distance, previous, start);
    }
    
    private int minDistance(int[] distance, boolean[] visited) {
        int min = INF;
        int minIndex = -1;
        
        for(int v = 0; v < n; v++) {
            if(!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    
    private void printSolution(int[] distance, int[] previous, int start) {
        System.out.println("Shortest paths from vertex " + label[start] + ":");
        for(int i = 0; i < n; i++) {
            if(i != start) {
                System.out.print("To " + label[i] + ": Distance = " + distance[i] + ", Path = ");
                printPath(previous, i);
                System.out.println();
            }
        }
    }
    
    private void printPath(int[] previous, int j) {
        if(previous[j] == -1) {
            System.out.print(label[j]);
            return;
        }
        printPath(previous, previous[j]);
        System.out.print(" -> " + label[j]);
    }
}
