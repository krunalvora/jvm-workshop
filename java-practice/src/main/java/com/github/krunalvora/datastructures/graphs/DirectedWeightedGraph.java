package com.github.krunalvora.datastructures.graphs;

import java.util.*;

public class DirectedWeightedGraph {
    private Map<Node, List<Edge>> adjacencyList;
    private Set<Node> visited;

    public DirectedWeightedGraph() {
        adjacencyList = new HashMap<>();
        visited = new HashSet<>();
    }

    public void addNode(Node node) {
        adjacencyList.put(node, new ArrayList<Edge>());
    }

    public void addEdge(Node source, Node dest, int weight) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(dest)) {
            System.out.println("Missing nodes. Cannot add edge.");
            return;
        } else {
            List<Edge> edges = adjacencyList.get(source);
            edges.add(new Edge(dest, weight));
            adjacencyList.put(source, edges);
        }
    }

    public void print() {
        for (Node node: adjacencyList.keySet()) {
            System.out.println(node.toString() + " : " + adjacencyList.get(node).toString());
        }
    }
}

class Node {
    String label;

    public Node(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}

class Edge {
    Node dest;
    int weight;

    public Edge(Node dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public String toString(){
        return "{ " + dest.toString() +" : " + String.valueOf(weight) + " }";
    }
}