package com.github.krunalvora.datastructures.graphs;

public class Dijkstra {

    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();

        Node A = new Node("A");
        graph.addNode(A);
        Node B = new Node("B");
        graph.addNode(B);
        Node C = new Node("C");
        graph.addNode(C);
        Node D = new Node("D");
        graph.addNode(D);
        Node E = new Node("E");
        graph.addNode(E);
        

        graph.addEdge(A, B, 1);
        graph.addEdge(A, C, 3);
        graph.addEdge(B, D, 2);

        graph.print();
    }

    public static void dijkstra(DirectedGraph g, int source) {

    }
    
}
