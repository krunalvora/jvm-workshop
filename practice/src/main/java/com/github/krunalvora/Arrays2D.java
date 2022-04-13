package com.github.krunalvora;

import java.util.Arrays;

public class Arrays2D {

    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{4, 5, 6}, {1, 2, 3}, {7, 8, 9}};

        System.out.println(Arrays.deepToString(arr));


        // Sort 2D array using lambda comparator
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        System.out.println(Arrays.deepToString(arr));


    }
    
    
}
