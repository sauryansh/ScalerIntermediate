package com._2array.day8introtoarr.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class _Q4A_ReverseEntireArray_Extra {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-1,4,7,6,-2,7,8,10));
        ArrayList<Integer> secondArrayList = new ArrayList<>(Arrays.asList(-1,6,3,2,8,9,10));

        System.out.println(new _Q4A_ReverseEntireArray_Extra().reverseArray(arrayList));
        System.out.println(new _Q4A_ReverseEntireArray_Extra().reverseArray(secondArrayList));
    }

    private boolean reverseArray(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        for (int i=0;i<n/2;i++){
            int temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(n-i-1));
            arrayList.set(n-i-1,temp);
        }
        System.out.println(arrayList);
        return true;
    }

    private boolean reverseArrayWhileLoop(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        int i=0;
        int j=n-1;
        while (i<j){
            int temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(j));
            arrayList.set(j,temp);
            i++;
            j--;
        }
        System.out.println(arrayList);
        return true;
    }

    //Without using extra variable
    private boolean reverseArrayWithoutExtraSpace(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        int i=0;
        int j=n-1;
        while (i<j){
            arrayList.set(i,arrayList.get(i)+arrayList.get(j));
            arrayList.set(j,arrayList.get(i)-arrayList.get(j));
            arrayList.set(i,arrayList.get(i)-arrayList.get(j));
            i++;
            j--;
        }
        System.out.println(arrayList);
        return true;
    }
}
