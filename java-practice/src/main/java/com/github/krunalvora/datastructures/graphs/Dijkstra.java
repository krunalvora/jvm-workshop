package com.github.krunalvora.datastructures.graphs;

import java.util.*;
import javafx.util.Pair;

public class Dijkstra {

    PriorityQueue<Pair<Integer, Node>> minHeap;
    int numNodes;
    boolean[] visited;
    List<Node> previous;
    int[] bestDistance;

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

        System.out.println(graph.getWeight(A, C));
    }

    public Dijkstra (int numNodes) {
        // TODO
        minHeap = new PriorityQueue<>();
        this.numNodes = numNodes;
        visited = new boolean[numNodes];
        previous = new ArrayList<>(numNodes);
        bestDistance = new int[numNodes];


    }

    public static void dijkstra(DirectedGraph g, int source) {

    }
    
}
