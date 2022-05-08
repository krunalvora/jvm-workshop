package com.github.krunalvora.datastructures.graphs;

import java.util.*;

public class DirectedWeightedGraph {
    private Map<Node, List<Edge>> adjacencyList;

    public DirectedWeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public Map<Node, List<Edge>> getAdjacencyList() {
        return this.adjacencyList;
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

    public int getWeight(Node source, Node dest) {
        if (adjacencyList.containsKey(source)) {
            List<Edge> edges = adjacencyList.get(source);
            for (Edge edge: edges) {
                if (edge.dest == dest) {
                    return edge.weight;
                }
            }
        }
        return -1;
    }

    public int getNumNodes() {
        return adjacencyList.keySet().size();
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