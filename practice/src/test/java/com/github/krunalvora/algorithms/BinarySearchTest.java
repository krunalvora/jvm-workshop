package com.github.krunalvora.algorithms;

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
    
    @Test
    public void testFirstOccurrence() {
        assertEquals(1, BinarySearch.firstOccurrence(new int[]{0, 1, 1, 1, 1, 2}, 1));
        assertEquals(-1, BinarySearch.firstOccurrence(new int[]{}, 1));
        assertEquals(-1, BinarySearch.firstOccurrence(new int[]{0, 1, 1, 1, 1, 2}, 3));
        assertEquals(0, BinarySearch.firstOccurrence(new int[]{1, 1, 1, 1, 1, 2}, 1));
    }

    @Test
    public void testLastOccurrence() {
        assertEquals(4, BinarySearch.lastOccurrence(new int[]{0, 1, 1, 1, 1, 2}, 1));
        assertEquals(-1, BinarySearch.lastOccurrence(new int[]{}, 1));
        assertEquals(-1, BinarySearch.lastOccurrence(new int[]{0, 1, 1, 1, 1, 2}, 3));
        assertEquals(4, BinarySearch.lastOccurrence(new int[]{1, 1, 1, 1, 1, 2}, 1));
    }

    @Test
    public void testLeastGreaterThan() {
        assertEquals(5, BinarySearch.leastGreaterThan(new int[]{0, 1, 1, 1, 1, 2}, 1));
        assertEquals(-1, BinarySearch.leastGreaterThan(new int[]{0, 1, 1, 1, 1, 2}, 2));
        assertEquals(0, BinarySearch.leastGreaterThan(new int[]{0, 1, 1, 1, 1, 2}, -1));
        assertEquals(-1, BinarySearch.leastGreaterThan(null, 1));
        assertEquals(-1, BinarySearch.leastGreaterThan(new int[]{}, 1));
    }


    @Test
    public void testGreatestLesserThan() {
        assertEquals(0, BinarySearch.greatestLesserThan(new int[]{0, 1, 1, 1, 1, 2}, 1));
        assertEquals(4, BinarySearch.greatestLesserThan(new int[]{0, 1, 1, 1, 1, 2}, 2));
        assertEquals(-1, BinarySearch.greatestLesserThan(new int[]{0, 1, 1, 1, 1, 2}, 0));
        assertEquals(-1, BinarySearch.greatestLesserThan(new int[]{0, 1, 1, 1, 1, 2}, -1));
        assertEquals(-1, BinarySearch.greatestLesserThan(null, 1));
        assertEquals(-1, BinarySearch.greatestLesserThan(new int[]{}, 1));
    }
}
