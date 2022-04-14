package com.github.krunalvora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void testContains() {
        assertEquals(true, BinarySearch.contains(new int[]{1, 2, 3, 4, 5}, 4));
        assertEquals(false, BinarySearch.contains(new int[]{1, 2, 3, 4, 5}, 0));
        assertEquals(false, BinarySearch.contains(new int[]{}, 0));
        assertEquals(false, BinarySearch.contains(null, 0));
        assertEquals(true, BinarySearch.contains(new int[3], 0));
        assertEquals(false, BinarySearch.contains(new int[3], 1));
    }    
}
