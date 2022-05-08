package com.github.krunalvora.datastructures.graph;

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
                if (edge.getDest() == dest) {
                    return edge.getWeight();
                }
            }
        }
        return -1;
    }

    public int getNumNodes() {
        return adjacencyList.keySet().size();
    }


}