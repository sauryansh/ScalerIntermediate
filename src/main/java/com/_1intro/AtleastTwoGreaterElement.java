package com._1intro;

import java.util.ArrayList;
import java.util.Arrays;

public class AtleastTwoGreaterElement {
    public static void main(String[] args) {
        AtleastTwoGreaterElement atleastTwoGreaterElement = new AtleastTwoGreaterElement();
        System.out.println(atleastTwoGreaterElement.solve(new ArrayList<>(Arrays.asList(391,634,740,441,75,444,65,611,679,59,878,102,42,190,801,571,79,686,523,580,199,497,879,334,200,202,991,341,479,563,112,550,494,468,56,644,53,581,836,461,905,849,838,434,818,350,585,280,252,834,510,420,395,776,118,886,19,809,534,143,933,15,999,514,230,531,666,841,861,703,972,622,640,21,811,476,751,430,308,996,165,812,424,412,903,601,226,239,728,135))));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A){
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int nextMax= Integer.MIN_VALUE;

        for (Integer integer : A) {
            if (integer > max) {
                nextMax = max;
                max = integer;
            } else if (integer > nextMax) {
                nextMax = integer;
            }
        }

        for (int i: A) {
            if((i!=max)&& (i!=nextMax)){
                result.add(i);
            }
        }
        return result;
    }
}
