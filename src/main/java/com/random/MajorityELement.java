package com.random;

public class MajorityELement {
    public static void main(String[] args) {
        int[] nums1 = {3, 2,3};
        int[] nums2 = {2,2,1,1,1,2,2};

        System.out.println("Majority element in nums1: " + findMajorityElement(nums1)); // Output: 3
        System.out.println("Majority element in nums2: " + findMajorityElement(nums2)); // Output: 2

    }

    public static int findMajorityElement(int[] nums) {
        int majorityELement = nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==majorityELement){
                count++;
            }else if(count==0){
                majorityELement=nums[i];
                count=1;
            }
            else{
                count--;
            }
        }

        int frequency = 0;
        for (int num : nums) {
            if (num == majorityELement) {
                frequency++;
            }
        }

        return frequency > nums.length / 2 ? majorityELement : -1;
    }
}
