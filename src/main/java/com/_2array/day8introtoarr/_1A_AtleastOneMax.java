package com._2array.day8introtoarr;

import java.util.ArrayList;
import java.util.Arrays;

public class _1A_AtleastOneMax {
    public static void main(String[] args) {
        _1A_AtleastOneMax a1AtleastOneMax = new _1A_AtleastOneMax();
        ArrayList<Integer> in= new ArrayList<>(Arrays.asList(-3,-2,6,8,4,8,5));
        System.out.println(a1AtleastOneMax.solve1(in));
    }

    public int solve(ArrayList<Integer> source){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<source.size();i++){
            if(source.get(i)>=max){
                max=source.get(i);
            }
        }

        int countOfMax= 0;

        for(int i=0;i<source.size();i++){
            if(source.get(i)==max){
                countOfMax++;
            }
        }

        return source.size()-countOfMax;
    }
    //One Iteration Solution ANS: 5
    public int solve1(ArrayList<Integer> source){
        int max = Integer.MIN_VALUE;
        int countOfMax= 0;

        for(int i=0;i<source.size();i++){
            if(source.get(i)>=max){
                if(source.get(i)==max){
                    countOfMax++;
                }else {
                    max=source.get(i);
                    countOfMax=1;
                }
            }
        }

        return source.size()-countOfMax;
    }
}
