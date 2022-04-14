package com.github.krunalvora;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 3;
        System.out.println(contains(nums, target));
        
    }

    public static boolean contains(int[] nums, int target) {

        if (nums == null) return false;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
        }
        return false;
    }

    public static int firstOccurrence(int[] nums) {
        return 0;
    }

    public static int lastOccurrence(int[] nums) {
        return 0;
    }

    public static int leastGreaterThan(int[] nums) {
        return 0;
    }

    public static int greatestLesserThan(int [] nums) {
        return 0;
    }
}
