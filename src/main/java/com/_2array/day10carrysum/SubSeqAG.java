package com._2array.day10carrysum;

public class SubSeqAG {
    public static void main(String[] args) {
        String A = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        System.out.println(new SubSeqAG().solve2(A));
    }
    public int solve(String A) {
        int size = A.length();
        int mod = 1000*1000*1000+7;
        int countOfA = 0;
        int result =0;
        for(int i=0;i<size;i++){
            if(A.charAt(i)=='A'){
                countOfA=countOfA+1;
            }else if(A.charAt(i)=='G'){
                result=(result+countOfA)%mod;
            }
        }
        result= result%mod;
        return result;
    }

    public int solve2(String A){
        int len = A.length();
        int countOfG =0;
        int result = 0;
        int mod = 1000*1000*1000+7;
        for (int i=len-1;i>=0;i--){
            if(A.charAt(i)=='G'){
                countOfG+=1;
            } else if (A.charAt(i)=='A') {
                result = (result+countOfG)%mod;
            }
        }
        return result%mod;
    }
    public int solve1(String A){
        int len=A.length();
        int c =0;

        for(int i=0;i<len;i++){
            if(A.charAt(i)=='A'){
                for (int j = i+1; j < len; j++) {
                    if(A.charAt(j)=='G'){
                        c++;
                    }
                }
            }
        }

        return c;

    }

}
