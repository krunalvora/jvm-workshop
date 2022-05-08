package com.github.krunalvora.datastructures.graph;

public class Edge {
    private Node dest;
    private int weight;

    public Edge(Node dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public Node getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return "{ " + dest.toString() +" : " + String.valueOf(weight) + " }";
    }
}
