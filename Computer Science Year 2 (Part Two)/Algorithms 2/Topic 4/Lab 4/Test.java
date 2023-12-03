public class Test {

    public static void main(String[] args) {
        // Create a new instance of the Graph class
        Graph graph = new Graph();

        // Add vertices to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Add edges between vertices with weights
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "A", 3);

        // Perform operations on the graph
        int mstCost = graph.MSTCost();
        System.out.println("Minimum Spanning Tree Cost: " + mstCost);

        int spCost = graph.SPCost("A", "C");
        System.out.println("Shortest Path Cost from A to C: " + spCost);
    }
}
