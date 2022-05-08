package com.github.krunalvora.datastructures.graph;

public class Graph2 {

    private int[][] adjacencyMatrix;

    public Graph2(int numOfNodes) {
        this.adjacencyMatrix = new int[numOfNodes][numOfNodes];
    }

    public void addEdge(int nodeA, int nodeB) {
        adjacencyMatrix[nodeA][nodeB] = 1;
    }
    
    public void print() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(" " + adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }
    
}
