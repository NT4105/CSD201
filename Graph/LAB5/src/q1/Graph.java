package q1;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int[][] a; // adjacency matrix
    private String[] label; // vertex labels
    private int n; // number of vertices
    
    public Graph() {
        n = 0;
        a = null;
        label = null;
    }
    
    public void setAMatrix(int[][] b, int m) {
        n = m;
        a = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                a[i][j] = b[i][j];
    }
    
    public void setLabel(String[] c) {
        label = new String[n];
        for(int i = 0; i < n; i++)
            label[i] = c[i];
    }
    
    // BFS traversal
    public void BFS(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(label[v] + " ");
            
            for(int i = 0; i < n; i++) {
                if(a[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    
    // DFS traversal
    public void DFS(int start) {
        boolean[] visited = new boolean[n];
        DFSUtil(start, visited);
    }
    
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(label[v] + " ");
        
        for(int i = 0; i < n; i++) {
            if(a[v][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }
}