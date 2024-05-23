package com._2array;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingElementInArray {
    public static void main(String[] args) {
        System.out.println(new MissingElementInArray().solve(new ArrayList<>(Arrays.asList(3,2,1,4,2))));
    }

    /**
     * Let's go through the array step by step and see how it changes with each iteration of the loop:
     * <p>
     * Given the input array [3, 2, 1, 4, 2]:
     * </p>
     * 1. **Iteration 1**: The element at index 0 is 3. The algorithm sets the element at index 3 to its negative value.
     *    - Array state: [3, 2, 1, -4, 2]
     * <p>
     * 2. **Iteration 2**: The element at index 1 is 2. The algorithm sets the element at index 2 to its negative value.
     *    - Array state: [3, 2, -1, -4, 2]
     * <p>
     * 3. **Iteration 3**: The element at index 2 is 1. The algorithm sets the element at index 1 to its negative value.
     *    - Array state: [3, -2, -1, -4, 2]
     * <p>
     * Now, let's see why the algorithm stops at this point. It encounters a negative value at index 1. According to the algorithm, if it finds a negative value during the iteration, it returns the absolute value of that negative number. In this case, the absolute value of -2 is 2. Thus, the algorithm stops at the third iteration and returns 2.
     * <p>
     * So, in this specific implementation, the algorithm doesn't traverse the entire array to find all duplicate elements. Instead, it stops as soon as it encounters a negative value, assuming that it represents the duplicate element.
     * <p>
     */
    public int solve(ArrayList<Integer> A){
        for(int i=0;i<A.size();i++) {

            int ind = Math.abs(A.get(i));
            if(A.get(i) < 0) {
                return ind;
            }
            A.set(ind, -A.get(ind));
        }
        return -1;
    }

    public int findDuplicate(ArrayList<Integer> nums) {
        int slow = nums.get(0);
        int fast = nums.get(0);
        do { // we are sure that at least one duplicate is there
            slow = nums.get(slow);
            fast = nums.get(nums.get(fast));
        } while(slow != fast);
        // find the head of loop
        fast = nums.get(0);
        while(slow != fast) {
            slow = nums.get(slow);
            fast = nums.get(fast);
        }
        return fast;
    }
}
