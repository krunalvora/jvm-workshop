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
        minHeap.add(new Pair<Node, Integer>(source, 0));

        // kinda BFS but with heap
        while (!minHeap.isEmpty()) {
            Pair<Node, Integer> pair = minHeap.poll();

            Node currNode = pair.getKey();
            int currDist = pair.getValue();

            if (visited.get(currNode) == true) {
                continue;
            }

            visited.put(currNode, true);

            for (Edge edge: adjacencyList.get(currNode)) {
                Node neighbor = edge.getDest();
                int neighborDist = currDist + graph.getWeight(currNode, neighbor);

                if (visited.get(neighbor) == false && neighborDist < bestDistance.get(neighbor)) {
                    bestDistance.put(neighbor, neighborDist);
                    previous.put(neighbor, currNode);
                    minHeap.add(new Pair<Node, Integer>(neighbor, neighborDist));
                }
            }
        }

        // print best distance
        System.out.println("Best distances from " + source.getLabel() + ": ");
        for (Node node: bestDistance.keySet()) {
            System.out.println(node.getLabel() + " : " + String.valueOf(bestDistance.get(node)));
        }

    }
    
}
