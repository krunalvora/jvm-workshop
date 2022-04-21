package com.github.krunalvora.datastructures;

import java.util.*;

public class Graphs {

    public static void main(String[] args) {

        /*

        0 - 1 - 2
        | / | /
        4 - 3

        */

        AdjacencyList graph = new AdjacencyList();
        graph.addNode(0);
        graph.addNode(1);

        graph.addEdge(0, 1);

        graph.printAdjacencyList();
    }
    
}

class AdjacencyMatrix {

    private int[][] adjacencyMatrix;

    public AdjacencyMatrix(int numOfNodes) {
        this.adjacencyMatrix = new int[numOfNodes][numOfNodes];
    }

    public void addEdge(int nodeA, int nodeB) {
        adjacencyMatrix[nodeA][nodeB] = 1;
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(" " + adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }

}

class AdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(int node) {
        adjacencyList.put(node, new ArrayList<>());
    }

    // nodeA -> nodeB
    public void addEdge(int nodeA, int nodeB) {
        if (!adjacencyList.containsKey(nodeA) || !adjacencyList.containsKey(nodeB)) {
            System.out.println("Missing nodes. Cannot add edge.");
            return;
        } else {
            List<Integer> neighbors = adjacencyList.get(nodeA);
            neighbors.add(nodeB);
            adjacencyList.put(nodeA, neighbors);
        }
    }

    public void printAdjacencyList() {
        for (int node: adjacencyList.keySet()) {
            System.out.println(node + " : " + adjacencyList.get(node));
        }
    }

}
