package graphs;

/* @author AlecBp */
public class GraphsTraining {

    public static void main(String[] args) {
        DirectedWeightedGraph dwg = new DirectedWeightedGraph(100);
        String[] labels = new String[]{"A", "N", "T", "E", "G", "J", "R"};

        for (int i = 0; i < labels.length; i++) {
            dwg.addVertex(labels[i]);
        }

        dwg.addEdge("A", "T", 80);
        dwg.addEdge("A", "N", 30);
        dwg.addEdge("T", "J", 50);
        dwg.addEdge("T", "R", 15);
        dwg.addEdge("T", "G", 10);
        dwg.addEdge("E", "R", 15);
        dwg.addEdge("E", "T", 8);
        dwg.addEdge("N", "T", 42);
        dwg.addEdge("N", "E", 32);
        dwg.addEdge("N", "G", 25);
        dwg.addEdge("R", "J", 20);
        dwg.addEdge("G", "E", 5);
        dwg.addEdge("G", "R", 45);

        dwg.printAdjancencyMatrix();
        
        System.out.println("Vertex\tDegree");
        for (int i = 0; i < labels.length; i++) {
            System.out.println(labels[i] + "\t" + dwg.getDegree(labels[i]));
        }
        System.out.println("");

        System.out.print("DFS:\t");
        dwg.DFS("T");
        System.out.print("BFS:\t");
        dwg.BFS("T");
        System.out.print("TS:\t");
        dwg.topologicalSort();
    }
}
