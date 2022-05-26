package com.github.krunalvora.algorithms.dynamicprogramming;

import java.util.*;
import javafx.util.*;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] 
 * such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */

public class Knapsack {

    Map<Pair<Integer, Integer>, Integer> memo;
    int[] amounts;
    int[] weights;
    int maxWeight;

    public int maxAmount(int[] weights, int[] amounts, int maxWeight) {
        this.amounts = amounts;
        this.weights = weights;
        this.maxWeight = maxWeight;
        this.memo = new HashMap<>();
        int max = rec(0, maxWeight);
        return max;
    }

    public int rec(int i, int remWeight) {

        Pair<Integer, Integer> pair = new Pair<>(i, remWeight);
        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }

        // base case: considered all the weights
        if ( i == weights.length) {
            return 0;
        }

        // base case: no capacity left in the knapsack for the current weight
        if (weights[i] > remWeight) {
            return 0;
        }

        int maxAmountIncl = amounts[i] + rec(i + 1, remWeight - weights[i]);  // including the current weight
        int maxAmountExcl = rec(i + 1, remWeight);                            // excluding the current weight

        memo.put(pair, Math.max(maxAmountExcl, maxAmountIncl));

        return memo.get(pair);
    }

    public static void main(String[] args) {

        int[] amounts = new int[]{20, 30, 15, 25, 10};
        int[] weights = new int[]{6, 13, 5, 10, 3};
        int maxWeight = 20;

        Knapsack knapsack = new Knapsack();
        int maxAmount = knapsack.maxAmount(weights, amounts, maxWeight);
        System.out.println(maxAmount);
    }
    
}
