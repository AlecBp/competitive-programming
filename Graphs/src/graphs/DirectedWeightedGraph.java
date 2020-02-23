package graphs;

import java.io.*;

/* @author AlecBp */
public class DirectedWeightedGraph {

    private double[][] table;
    private int numV;
    private int maxV;
    private String[] label;

    public DirectedWeightedGraph(int maxV) {
        this.maxV = maxV;
        numV = 0;
        table = new double[maxV][maxV];
        label = new String[maxV];
    }

    public void loadGraph(String fileName) throws Exception {
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        int numVertices = Integer.parseInt(br.readLine());
        for (int i = 0; i < numVertices; i++) {
            addVertex(br.readLine());
        }
        int numEdges = Integer.parseInt(br.readLine());
        String line;
        String[] data;
        for (int i = 0; i < numEdges; i++) {
            line = br.readLine();
            data = line.split(" ");
            addEdge(data[0], data[1], Double.parseDouble(data[2]));
        }
    }

    public void topologicalSort() {
        boolean[] visited = new boolean[numV];
        // Last index of stack is the current number of items in the array
        int[] stack = new int[numV + 1];
        for (int i = 0; i < numV; i++) {
            if (!visited[i]) {
                visited[i] = true;
                topologicalSort(i, visited, stack);
            }
        }
        for (int i = 0; i < numV; i++) {
            System.out.print(label[stack[i]] + "\t");
        }
        System.out.println("");
    }

    public void topologicalSort(int vertex, boolean[] visited, int[] stack) {
        for (int i = 0; i < numV; i++) {
            if (table[vertex][i] > 0 && !visited[i]) {
                visited[i] = true;
                topologicalSort(i, visited, stack);
            }
        }
        stack[stack[stack.length - 1]] = vertex;
        stack[stack.length - 1]++;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    private int findVertex(String key) {
        for (int i = 0; i < numV; i++) {
            if (key.equals(label[i])) {
                return i;
            }
        }
        return -1;
    }

    public void addVertex(String key) {
        label[numV++] = key;
    }

    public boolean addEdge(String from, String to, double w) {
        int idxFrom = findVertex(from);
        int idxTo = findVertex(to);
        if (idxFrom != -1 && idxTo != -1) {
            table[idxFrom][idxTo] = w;
            return true;
        }
        return false;
    }

    public boolean addEdge(int idxFrom, int idxTo, double w) {
        table[idxFrom][idxTo] = w;
        return true;
    }

    public void DFS(String start) {
        int loc = findVertex(start);
        if (loc != -1) {
            boolean[] visited = new boolean[numV];
            DFS(loc, visited);
        }
        System.out.println("");
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[numV];
        DFS(start, visited);
        System.out.println("");
    }

    private void DFS(int from, boolean[] visited) {
        visited[from] = true;
        System.out.print(label[from] + "\t");
        for (int i = 0; i < numV; i++) {
            if (table[from][i] > 0 && !visited[i]) {
                DFS(i, visited);
            }
        }
    }

    public int getDegree(int vertex) {
        int degree = 0;
        for (int i = 0; i < numV; i++) {
            if (table[vertex][i] > 0) {
                degree++;
            }
        }
        return degree;
    }

    public void BFS(String key) {
        boolean[] visited = new boolean[numV];
        Queue q = new Queue();
        String data;
        int loc = findVertex(key);
        q.enqueue(key);

        if (loc != -1) {
            visited[loc] = true;
            while (q.peek() != null) {
                data = q.dequeue();
                System.out.print(data + "\t");

                loc = findVertex(data);
                for (int i = 0; i < numV; i++) {
                    if (table[loc][i] > 0 && !visited[i]) {
                        q.enqueue(label[i]);
                        visited[i] = true;
                    }
                }
            }
        }
        System.out.println("");
    }

    public int getDegree(String vertex) {
        int degree = 0;
        int loc = findVertex(vertex);
        if (loc != -1) {
            for (int i = 0; i < numV; i++) {
                if (table[loc][i] > 0) {
                    degree++;
                }
            }
        }
        return degree;
    }

    public void printAdjancencyMatrix() {
        System.out.print("\t");
        for (int i = 0; i < numV; i++) {
            System.out.print("[" + label[i] + "]" + "\t");
        }
        System.out.println("");
        for (int i = 0; i < numV; i++) {
            System.out.print("[" + label[i] + "]" + "\t");
            for (int j = 0; j < numV; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
