package com.github.krunalvora;


public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 3;
        System.out.println(contains(nums, target));
        
    }


    public static boolean contains(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

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


    public static int firstOccurrence(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }


    public static int lastOccurrence(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    // First occurrence of the element least greater than the target
    public static int leastGreaterThan(int[] nums, int target) {
        
        int ans = -1;

        if (nums == null || nums.length == 0) return ans;
        if (nums[nums.length - 1] == target) return ans;
 
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Last occurrence of the element greatest lesser than the target
    public static int greatestLesserThan(int [] nums, int target) {
        int ans = -1;
        if (nums == null || nums.length == 0) return ans;
        if (nums[0] == target) return ans;
 
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                ans =  mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
