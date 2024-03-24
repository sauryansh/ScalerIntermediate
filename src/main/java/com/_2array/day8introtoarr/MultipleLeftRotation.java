package com._2array.day8introtoarr;

import java.util.ArrayList;

public class MultipleLeftRotation {
    public static void main(String[] args) {
        System.out.println(new MultipleLeftRotation().solve(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<>(java.util.Arrays.asList(2, 3))));
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList< ArrayList<Integer> > ans = new ArrayList<>();
        int n = a.size();
        for(int x : b) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++)
                temp.add(a.get( (i+x) % n ));
            ans.add(temp);
        }
        return ans;
    }
}

