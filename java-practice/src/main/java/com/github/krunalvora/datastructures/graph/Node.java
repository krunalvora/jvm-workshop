package com.github.krunalvora.datastructures.graph;

public class Node {
    private String label;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        return label;
    }
}