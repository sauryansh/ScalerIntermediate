package com._1intro.day5;

public class TImeComplexity {

    public void solve(int n){
        int i=n;
        while(i>0){
            if(i%2==0){
                for (int j=1;j<=n*n;j+=2){
                    System.out.println("Hey - I am busy looking at my phone");
                }
            }
            i/=2;
        }
    }
}
