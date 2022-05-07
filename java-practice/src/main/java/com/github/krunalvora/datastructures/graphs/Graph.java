package com.github.krunalvora.datastructures.graphs;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private Set<Integer> visited;

    public Graph() {
        adjacencyList = new HashMap<>();
        visited = new HashSet<>();
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


    public void print() {
        for (int node: adjacencyList.keySet()) {
            System.out.println(node + " : " + adjacencyList.get(node));
        }
    }

    public void dfs() {
        for (int node: adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                dfsRec(node);
            }
        }
    }

    public void dfsRec(int node) {
        for (int neighbor: adjacencyList.get(node)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                System.out.println("Visiting node: " + neighbor);
                dfsRec(neighbor);
            }
        }
    }

    

    // iterative dfs
    public void dfsItr() {
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