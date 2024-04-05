package com._2array.day33array1;

import java.util.ArrayList;
import java.util.Arrays;

public class _01_AP_AddOneToNumber {
    public static void main(String[] args) {
        System.out.println(new _01_AP_AddOneToNumber().plusOne(new ArrayList<>(Arrays.asList(5,8,9,0,4))));
    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n=A.size();
        A.set(n - 1, A.get(n - 1) + 1);//getting the last index and adding 1 to arraylist element
        int carry = A.get(n - 1) / 10;//if 10, then our carry is 1
        A.set(n - 1, A.get(n - 1) % 10);//set the last digit as a remainder
        for (int i = n - 2; i >= 0; i--)
        {
            if (carry == 1)
            {
                A.set(i, A.get(i) + 1);
                carry = A.get(i) / 10;
                A.set(i, A.get(i) % 10);
            }
        }

        if (carry == 1)
            A.add(0, 1);
        int j=0;

        while (A.get(j)==0) {
            j++;
            if(A.get(j)!=0) { //on first non-negative number
                break;
            }
        }
        ArrayList<Integer> result= new ArrayList<>();
        for(int i=j;i<A.size();i++)
        {
            result.add(A.get(i));
        }
        return result;
    }
}
