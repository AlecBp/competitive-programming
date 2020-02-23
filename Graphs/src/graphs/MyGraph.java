package graphs;

import java.util.LinkedList;
import java.util.Queue;

/* @author Alec Pagliarussi */
public class MyGraph {

    private boolean isDirected;
    private boolean isWeighted;
    private int numNodes;
    private int numEdges;
    private int[][] table;
    private String[] label;

    public MyGraph(boolean isDirected, boolean isWeighted, int numNodes, int numEdges) {
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.numNodes = numNodes;
        this.numEdges = numEdges;
        this.table = new int[this.numNodes][this.numNodes];
        this.label = new String[numNodes];
        setLabelNames();
    }

    public MyGraph(boolean isDirected, boolean isWeighted, int numNodes, int numEdges, String[] label) {
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.numNodes = numNodes;
        this.numEdges = numEdges;
        this.table = new int[this.numNodes][this.numNodes];
        this.label = label;
    }

    // If you assume that you might use cost 0 in a weighted graph to represent a connection, then use -1 to represent unconnected
    public void setMatrixMinusOne() {
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                table[i][j] = -1;
            }
        }
    }

    // Mark self connections with the specified value
    public void selfConnections(int val) {
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                table[i][j] = val;
            }
        }
    }

    private void setLabelNames() {
        for (int i = 0; i < numNodes; i++) {
            label[i] = String.valueOf(i);
        }
    }

    public void addEdge(int a, int b, int w) {
        // a to b with weight
        table[a][b] = w;
        if (!isDirected) {
            table[b][a] = w;
        }
    }

    public void addEdge(String a, String b, int w) {
        // a to b with weight
        int indexA = findLabelIndex(a);
        int indexB = findLabelIndex(b);
        if (indexA != -1 && indexB != -1) {
            table[indexA][indexB] = w;
            if (!isDirected) {
                table[indexB][indexA] = w;
            }
        } else {
            // Couldnt find a or b in the label array
            System.out.println("ERROR: NOT A VALID NODE");
        }
    }

    public void addEdge(int a, int b) {
        // a to b no weight
        table[a][b] = 1;
        if (!isDirected) {
            table[b][a] = 1;
        }
    }

    public void addEdge(String a, String b) {
        // a to b with weight
        int indexA = findLabelIndex(a);
        int indexB = findLabelIndex(b);
        if (indexA != -1 && indexB != -1) {
            table[indexA][indexB] = 1;
            if (!isDirected) {
                table[indexB][indexA] = 1;
            }
        } else {
            // Couldnt find a or b in the label array
            System.out.println("ERROR: NOT A VALID NODE");
        }
    }

    private int findLabelIndex(String key) {
        for (int i = 0; i < numNodes; i++) {
            if (key.equals(label[i])) {
                return i;
            }
        }
        return -1;
    }

    public void printAdjacencyMatrix() {
        System.out.print("\t");
        for (int i = 0; i < numNodes; i++) {
            System.out.print("[" + label[i] + "]\t");
        }
        System.out.println("");
        for (int i = 0; i < numNodes; i++) {
            System.out.print("[" + label[i] + "]" + "\t");
            for (int j = 0; j < numNodes; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void printTraverse_DFS(String initialNode) {
        int startNode = findLabelIndex(initialNode);
        if (startNode != -1) {
            boolean[] visited = new boolean[numNodes];
            dfs(startNode, visited);
            System.out.println("");
        }
    }

    public void printTraverse_DFS(int initialNode) {
        boolean[] visited = new boolean[numNodes];
        dfs(initialNode, visited);
        System.out.println("");
    }

    private void dfs(int curr, boolean[] visited) {
        System.out.print(curr + "\t");
        visited[curr] = true;
        for (int i = 0; i < numNodes; i++) {
            if (table[curr][i] >= 0) {
                if (!visited[i]) {
                    dfs(i, visited);
                }
            }
        }
        visited[curr] = true;
    }

    public void printTraverse_BFS(String initialNode) {
        int startNode = findLabelIndex(initialNode);
        if (startNode != -1) {
            printTraverse_BFS(startNode);
        }
    }

    public void printTraverse_BFS(int initialNode) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[numNodes];

        q.add(initialNode);
        visited[initialNode] = true;

        while (q.size() != 0) {
            int curr = q.poll();
            System.out.print(curr + "\t");
            for (int i = 0; i < numNodes; i++) {
                if (table[curr][i] >= 0 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println("");
    }
    
    
}
