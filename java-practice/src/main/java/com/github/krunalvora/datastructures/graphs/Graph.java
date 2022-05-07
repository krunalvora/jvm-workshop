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
        System.out.println("DFS for graph: ");
        for (int node: adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                dfsHelper(node);
            }
        }
        visited.clear();
    }

    // dfs recursive helper
    public void dfsHelper(int node) {
        System.out.println("Visiting node: " + node);
        visited.add(node);
        for (int neighbor: adjacencyList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor);
            }
        }
    }

    public void bfs() {
        System.out.println("BFS for graph: ");
        for (int node: adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                bfsHelper(node);
            }
        }
        visited.clear();
    }

    public void bfsHelper(int node) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            System.out.println("Visiting node: " + polled);
            visited.add(polled);
            for (int neighbor: adjacencyList.get(polled)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
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