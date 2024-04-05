package com._2array.day13interview;

public class LengthOfLongestConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestConsecutiveOnes().solve("111011101"));
        System.out.println(new LengthOfLongestConsecutiveOnes().solve("1111111111111"));
        System.out.println(new LengthOfLongestConsecutiveOnes().solve("111000"));
        System.out.println(new LengthOfLongestConsecutiveOnes().solve("000"));
        //System.out.println(new LengthOfLongestConsecutiveOnes().solve1("01101110111"));
        System.out.println(new LengthOfLongestConsecutiveOnes().solve1("111001"));
    }

    public int solve(String A) {
        int len = A.length();
        int count_one = getCountOne(A, len);

        int[] left = getLeftCount(A, len);;
        int[] right = getRightCount(A, len);

        int cnt=0;
        int max_cnt =0;
        int flag=0;

        for(int i=1;i<len-1;i++){
            if(A.charAt(i)=='0'){
                int sum = left[i-1]+right[i+1];
                if(sum<count_one)
                    cnt=sum+1;
                else
                    cnt=sum;

                max_cnt=Math.max(max_cnt,cnt);
                cnt=0;
                flag=1;
            }
        }
        if(flag==0)
            max_cnt = count_one;
        return max_cnt;
    }

    private static int[] getRightCount(String A, int len) {
        int[] right = new int[len];

        //Right
        for(int i = len -1; i>=0; i--){
            if(i== len -1){
                if(A.charAt(i)=='1') {
                    right[i]=1;
                }else{
                    right[i]=0;
                }
            }else{
                if(A.charAt(i)=='1') {
                    right[i]=right[i+1]+1;
                }else{
                    right[i]=0;
                }
            }
        }
        return right;
    }

    private static int[] getLeftCount(String A, int len) {
        int []left = new int[len];
        for(int i = 0; i< len; i++){
            if(i==0){
               if(A.charAt(i)=='1') {
                 left[i]=1;
               }else{
                 left[i]=0;
               }
            }else{
                if(A.charAt(i)=='1') {
                    left[i]= left[i-1]+1;
                }else{
                    left[i]=0;
                }
            }
        }
        return left;
    }

    private static int getCountOne(String A, int len) {
        int count_one =0;
        for(int i = 0; i< len; i++){
            if(A.charAt(i)=='1'){
                count_one +=1;
            }
        }
        return count_one;
    }

    //2nd Approach
    public int solve1(String A) {
        int n = A.length();
        int maxLen =0; //Max Length of contiguous subarray
        int left = 0;  //left, counter and I initialized to 0 track the current state while iterating through the string.
        int counter = 0;
        int totalOneCount = 0;

        //Count total '1's in the string
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='1'){
                totalOneCount++;
            }
        }

        int i=0;
        //The code then iterates through the string A.
        //When encountering '1's, it increments the counter and updates maxLen if the current length is greater.
        //When encountering '0's, it sets the left to the current counter, resets counter to 0, and looks ahead to count consecutive '1's.
        //After counting, it checks if flipping one '0' would result in a longer subarray (left + counter + 1) or if keeping the current sequence (left + counter) is better.
        //maxLen is updated with the maximum length found so far.
        while(i<n){
            if(A.charAt(i)=='1'){
                counter++;
                maxLen= Math.max(maxLen,counter);
                i++;
            }else{
                left = counter;
                counter=0;
                i++;
                while (i < n && A.charAt(i) == '1') {
                    counter++;
                    i++;
                }
                if (left != 0 || counter != 0) {
                    if (totalOneCount == (left + counter)) {
                        maxLen = Math.max(maxLen, left + counter);
                    } else {
                        maxLen = Math.max(maxLen, left + counter + 1);
                    }
                }
            }
        }
        return maxLen;
    }
}
