package com._2array.day10carrysum;

import java.util.ArrayList;
import java.util.Arrays;
public class EvenSubarrays {
    public static void main(String[] args) {
/*        System.out.println(new EvenSubarrays().solve(new ArrayList<>(Arrays.asList(10,3,5,7,9,20))));
        System.out.println(new EvenSubarrays().solve(new ArrayList<>(Arrays.asList(19,2,4,8,16,15))));
        System.out.println(new EvenSubarrays().solve(new ArrayList<>(Arrays.asList(18,20,6,4,2,10,40))));
        System.out.println(new EvenSubarrays().solve(new ArrayList<>(Arrays.asList(13,14,16,20,40,2))));
        System.out.println(new EvenSubarrays().solve(new ArrayList<>(Arrays.asList(24,14,16,20,40,17))));*/
        System.out.println(new EvenSubarrays().solve(new ArrayList<>(Arrays.asList(2,2,4,6,18,8))));


    }
    public String solve(ArrayList<Integer> A) {
        int size = A.size();
        int start=0,end=0;
        if (((size & 1) == 1) || (A.get(0) & 1) == 1 || (A.get(size-1) & 1) == 1) {
            return "NO";
        }

        for(int i=1;i<size;i++){ //start at index 1
            if((A.get(i)&1)==0){ //
                if(((end-start+1)&1)==0){
                    start=end=i; // start and end are same
                }else{
                    end=i;
                }
            }else{
                end=i;
            }
        }

        if(((end-start+1)&1)==0) {
            System.out.println("start: "+start + " end: "+ end);
            return "YES";
        }else{
            return "NO";
        }
    }


    public String solve1(ArrayList<Integer> A) {
        int size = A.size();

        if(
                ((A.get(0)&1)==1) ||
                        ((A.get(size-1)&1)==1)||
                        ((size&1)==1)
        )
        {
            return "NO";
        }else{
            return "YES";
        }

    }
}
