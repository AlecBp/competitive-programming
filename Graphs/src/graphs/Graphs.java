package graphs;

/* @author Alec */
public class Graphs {

    public static void main(String[] args) {
//        String[] label = {"A", "B", "C", "D", "E"};
//        MyGraph graph = new MyGraph(false, true, 5, 7, label);
//        graph.setMatrixMinusOne();
//        graph.printAdjacencyMatrix();
//
//        graph.addEdge(0, 1, 6);
//        graph.addEdge(1, 2, 4);
//        graph.addEdge(0, 4, 4);
//        graph.addEdge(0, 3, 7);
//        graph.addEdge(3, 2, 5);
//        graph.addEdge(4, 1, 3);
//        graph.addEdge(4, 2, 8);
//
//        graph.printAdjacencyMatrix();
//
//        // Use label or node number
//        graph.printTraverse_DFS("C");
//        graph.printTraverse_DFS(2);
//
//        graph.printTraverse_BFS(2);
//        graph.printTraverse_BFS("C");

        // Example 2
        String[] label2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        MyGraph graph2 = new MyGraph(false, true, 9, 14, label2);
        graph2.setMatrixMinusOne();

        graph2.addEdge("A", "B", 4);
        graph2.addEdge("A", "H", 8);
        graph2.addEdge("B", "C", 8);
        graph2.addEdge("B", "H", 11);
        graph2.addEdge("H", "G", 1);
        graph2.addEdge("H", "I", 7);
        graph2.addEdge("G", "I", 6);
        graph2.addEdge("G", "F", 2);
        graph2.addEdge("F", "C", 4);
        graph2.addEdge("F", "D", 14);
        graph2.addEdge("F", "E", 10);
        graph2.addEdge("E", "D", 9);
        graph2.addEdge("C", "D", 7);
        graph2.addEdge("C", "I", 2);
        
        graph2.printAdjacencyMatrix();
    }
}
