package com.github.krunalvora.datastructures.graphs;

public class GraphMain {

    public static void main(String[] args) {

        /*

        0 - 1 - 2
        |   | 
        4   3

        */

        // With an adjacency list
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);

        graph.print();

        graph.dfs();

        // with an adjacency matrix
        // Graph2 graph2 = new Graph2(3);
        // graph2.addEdge(0, 1);
        // graph2.addEdge(0, 2);
        // graph2.print();
        
    }
    
}


