package com.day22hashing1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElement {

    public static void main(String[] args) {
        CommonElement commonElement= new CommonElement();
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(1,2,2,1));
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(2,3,1,2));

        System.out.println(commonElement.solve(A,B));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer> te = new HashMap<>();
        for(Integer i : A){
            if(te.containsKey(i)){
                te.put(i,te.get(i)+1);
            }else{
                te.put(i,1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer i : B){
            if(te.containsKey(i)){
                ans.add(i);
                te.put(i,te.get(i)-1); // Update the count in hashmap
                if(te.get(i)==0){
                    te.remove(i); // Remove the key if count is 0
                }
            }
        }

        System.out.println(te);
        return ans;
    }
}
