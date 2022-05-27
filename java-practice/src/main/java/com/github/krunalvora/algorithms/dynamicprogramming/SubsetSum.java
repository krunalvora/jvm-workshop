package com.github.krunalvora.algorithms.dynamicprogramming;

import java.util.*;
import javafx.util.*;

/**
 * Given an array of strictly positive integers arr and a strictly positive integer k,
 * count the number of subsets that sum to k.
 * 
 * [1, 2, 3, 1, 4]
 * k = 6
 * Ans: 4 since there are 4 subsets summing to 6
 * 1, 2, 3
 * 2, 3, 1
 * 2, 4
 * 1, 1, 4
 */


public class SubsetSum {

    static Map<Pair<Integer, Integer>, Integer> memo;

    public static int countSubSets(int[] arr, int k) {
        memo = new HashMap<>();
        int output = rec(arr, 0, k);
        return output;
    }

    public static int rec(int[] arr, int i, int k) {
        Pair<Integer, Integer> pair = new Pair<>(i, k);
        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }

        if (k == 0) return 1;

        if ( k < 0 || i == arr.length) return 0;

        memo.put(pair, rec(arr, i + 1, k) + rec(arr, i + 1, k - arr[i]));

        return memo.get(pair);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 4};
        int subsetsCount = countSubSets(arr, 6);
        System.out.println(subsetsCount);
    }

}
