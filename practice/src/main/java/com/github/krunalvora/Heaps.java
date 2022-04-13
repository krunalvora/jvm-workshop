package com.github.krunalvora;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heaps {

    public static void main(String[] args) {
        
        // Create min heap in Java
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(100);

        System.out.println(minHeap.toString());


        // Create max heap in Java
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(1);
        maxHeap.add(4);
        maxHeap.add(100);

        System.out.println(maxHeap.toString());

    }


}