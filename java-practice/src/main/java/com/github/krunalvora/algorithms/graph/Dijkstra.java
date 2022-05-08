package com.github.krunalvora.algorithms.graph;

import java.util.*;
import com.github.krunalvora.datastructures.graph.DirectedWeightedGraph;
import com.github.krunalvora.datastructures.graph.Edge;
import com.github.krunalvora.datastructures.graph.Node;
import javafx.util.Pair;

public class Dijkstra {

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
        graph.addEdge(B, C, 1);

        // graph.print();

        // System.out.println(graph.getWeight(A, C));

        dijkstra(graph, A);
        System.out.println("Shortest path from source to target: " + dijkstraSingleTarget(graph, A, C));
    }

   

    public static void dijkstra(DirectedWeightedGraph graph, Node source) {

        Map<Node, List<Edge>> adjacencyList = graph.getAdjacencyList();

        // min heap sorted by distance from node
        PriorityQueue<Pair<Node, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        Map<Node, Boolean> visited = new HashMap<>();

        Map<Node, Node> previous = new HashMap<>();
        
        Map<Node, Integer> bestDistance = new HashMap<>();

        for (Node node: adjacencyList.keySet()) {
            visited.put(node, false);
            previous.put(node, null);
            bestDistance.put(node, Integer.MAX_VALUE);
        }

        bestDistance.put(source, 0);
        minHeap.add(new Pair<>(source, 0));

        while (!minHeap.isEmpty()) {
            Pair<Node, Integer> pair = minHeap.poll();

            Node currNode = pair.getKey();

            if (visited.get(currNode)) continue;
            visited.put(currNode, true);

            int currDist = pair.getValue();

            for (Edge edge: adjacencyList.get(currNode)) {
                Node nextNode = edge.getDest();
                if (visited.get(nextNode)) continue;

                int nextDist = currDist + graph.getWeight(currNode, nextNode);

                if (nextDist < bestDistance.get(nextNode)) {
                    minHeap.add(new Pair<Node,Integer>(nextNode, nextDist));
                    bestDistance.put(nextNode, nextDist);
                    previous.put(nextNode, currNode);
                }
            }
        }

        // print best distance
        System.out.println("Best distances from " + source.getLabel() + ": ");
        for (Node node: bestDistance.keySet()) {
            System.out.println(node.getLabel() + " : " + String.valueOf(bestDistance.get(node)));
        }

    }


    public static int dijkstraSingleTarget(DirectedWeightedGraph graph, Node source, Node target) {

        Map<Node, List<Edge>> adjacencyList = graph.getAdjacencyList();

        // min heap sorted by distance from node
        PriorityQueue<Pair<Node, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        Map<Node, Boolean> visited = new HashMap<>();

        Map<Node, Node> previous = new HashMap<>();
        
        Map<Node, Integer> bestDistance = new HashMap<>();

        for (Node node: adjacencyList.keySet()) {
            visited.put(node, false);
            previous.put(node, null);
            bestDistance.put(node, Integer.MAX_VALUE);
        }

        bestDistance.put(source, 0);
        minHeap.add(new Pair<>(source, 0));

        while (!minHeap.isEmpty()) {
            Pair<Node, Integer> pair = minHeap.poll();

            Node currNode = pair.getKey();

            // ONLY CHANGE from the above method
            if (currNode == target) break;

            if (visited.get(currNode)) continue;
            visited.put(currNode, true);

            int currDist = pair.getValue();

            for (Edge edge: adjacencyList.get(currNode)) {
                Node nextNode = edge.getDest();
                if (visited.get(nextNode)) continue;

                int nextDist = currDist + graph.getWeight(currNode, nextNode);

                if (nextDist < bestDistance.get(nextNode)) {
                    minHeap.add(new Pair<Node,Integer>(nextNode, nextDist));
                    bestDistance.put(nextNode, nextDist);
                    previous.put(nextNode, currNode);
                }
            }
        }

        return bestDistance.get(target);

    }
    
}
