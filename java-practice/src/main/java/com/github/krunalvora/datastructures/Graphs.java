package com.github.krunalvora.datastructures;

import java.util.*;

public class Graphs {

    public static void main(String[] args) {

        /*

        0 - 1 - 2
        |   | 
        4   3

        */

        // With an adjacency list
        AdjacencyList graphAdjacencyList = new AdjacencyList();
        graphAdjacencyList.addNode(0);
        graphAdjacencyList.addNode(1);
        graphAdjacencyList.addNode(2);
        graphAdjacencyList.addNode(3);
        graphAdjacencyList.addNode(4);

        graphAdjacencyList.addEdge(0, 1);
        graphAdjacencyList.addEdge(1, 2);
        graphAdjacencyList.addEdge(0, 4);
        graphAdjacencyList.addEdge(1, 3);

        graphAdjacencyList.printAdjacencyList();

        graphAdjacencyList.dfs();


        // with an adjacency matrix
        AdjacencyMatrix graphAdjacencyMatrix = new AdjacencyMatrix(3);
        graphAdjacencyMatrix.addEdge(0, 1);
        graphAdjacencyMatrix.addEdge(0, 2);

        graphAdjacencyMatrix.printAdjacencyMatrix();
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

    public void dfs() {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (int node: adjacencyList.keySet()) {
            stack.add(node);
            while (!stack.isEmpty()) {
                int popped = stack.pop();
                if (!visited.contains(popped)) {
                    visited.add(popped);
                    System.out.print(popped + " ");
                    List<Integer> neighbors = adjacencyList.get(popped);
                    for (int neighbor: neighbors) {
                        stack.add(neighbor);
                    }
                }
            }

        }
        System.out.println();
    }

}
