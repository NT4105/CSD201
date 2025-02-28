//  Minimum Spanning Tree using Prim's algorithm:
package q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WGraph {
    private int[][] weight;
    private String[] label;
    private int n;
    private final int INF = 999999;
    
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
    
    public void primMST() {
        int[] parent = new int[n]; // Array to store MST
        int[] key = new int[n];    // Key values to pick minimum weight edge
        boolean[] mstSet = new boolean[n]; // Vertices included in MST
        
        // Initialize all keys as infinite
        for(int i = 0; i < n; i++) {
            key[i] = INF;
            mstSet[i] = false;
        }
        
        // Start with first vertex
        key[0] = 0;
        parent[0] = -1;
        
        // Construct MST
        for(int count = 0; count < n-1; count++) {
            // Pick the minimum key vertex not yet included in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            
            // Update key and parent index of adjacent vertices
            for(int v = 0; v < n; v++) {
                if(weight[u][v] != 0 && !mstSet[v] && weight[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = weight[u][v];
                }
            }
        }
        
        // Print the MST
        printMST(parent);
    }
    
    private int minKey(int[] key, boolean[] mstSet) {
        int min = INF;
        int minIndex = -1;
        
        for(int v = 0; v < n; v++) {
            if(!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    
    private void printMST(int[] parent) {
        int totalWeight = 0;
        System.out.println("Minimum Spanning Tree edges:");
        System.out.println("Edge \tWeight");
        for(int i = 1; i < n; i++) {
            System.out.println(label[parent[i]] + " - " + label[i] + "\t" + weight[i][parent[i]]);
            totalWeight += weight[i][parent[i]];
        }
        System.out.println("Total MST weight: " + totalWeight);
    }
    
    // Optional: Kruskal's algorithm implementation
    public void kruskalMST() {
        // Create edge list
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(weight[i][j] != 0) {
                    edges.add(new Edge(i, j, weight[i][j]));
                }
            }
        }
        
        // Sort edges by weight
        Collections.sort(edges);
        
        DisjointSet ds = new DisjointSet(n);
        List<Edge> mst = new ArrayList<>();
        
        for(Edge edge : edges) {
            if(ds.find(edge.src) != ds.find(edge.dest)) {
                ds.union(edge.src, edge.dest);
                mst.add(edge);
            }
        }
        
        // Print result
        System.out.println("\nMinimum Spanning Tree (Kruskal's):");
        int totalWeight = 0;
        for(Edge edge : mst) {
            System.out.println(label[edge.src] + " - " + label[edge.dest] + "\t" + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total MST weight: " + totalWeight);
    }
    
    // Helper classes for Kruskal's algorithm
    private class Edge implements Comparable<Edge> {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    
    private class DisjointSet {
        int[] parent;
        int[] rank;
        
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            
            if(rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if(rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }
}
