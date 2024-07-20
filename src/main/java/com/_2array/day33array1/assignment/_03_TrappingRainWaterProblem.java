package com._2array.day33array1.assignment;

import java.util.Arrays;

public class _03_TrappingRainWaterProblem {
    public static void main(String[] args) {
        int[] height = {4, 1, 0, 2, 1, 7, 1, 3, 2, 1, 2, 1};
        System.out.println("Total trapped water: " + trap(height)); // Output: 6
        System.out.println("Total trapped water1: " + trap1(height)); // Output: 6
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        //left max calculation
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        System.out.println(Arrays.toString(leftMax));
        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(rightMax));

        // Calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }


    public static int trap1(int[] height) {
        int left = 0; // Initialize the left pointer
        int right = height.length - 1; // Initialize the right pointer
        int leftMax = 0; // Initialize the maximum height on the left
        int rightMax = 0; // Initialize the maximum height on the right
        int water = 0; // Initialize the total trapped water

        // Loop until the two pointers meet
        while (left < right) {
            // Check if the height at the left pointer is less than or equal to the height at the right pointer
            if (height[left] <= height[right]) {
                // Update the maximum height on the left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Calculate the trapped water at the current position and add it to the total
                    water += leftMax - height[left];
                }
                // Move the left pointer to the next position
                left++;
            } else if(height[left]>height[right]) {
                // Update the maximum height on the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Calculate the trapped water at the current position and add it to the total
                    water += rightMax - height[right];
                }
                // Move the right pointer to the previous position
                right--;
            }
        }

        return water; // Return the total trapped water
    }


}

