package com._1intro;

public class _4A_SQRT {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        _4A_SQRT a4Sqrt = new _4A_SQRT();
        //System.out.println(sqrt.solve(17));
        System.out.println(a4Sqrt.sqrtValue(16));
    }
    public int solve(int A) {
        int num =0;
        for(int i=1;i*i<=A;i++){
            int val =i*i;
            if(val<=A){
                num = i;
            }
        }
        return num*num==A?num:-1;
    }

    public int sqrtValue(int num){
        int start =1;
        int end = num;
        long result = 0;
        while(start<=end){
            long mid = start + (end-start)/2;
            if(mid*mid<=num){
                result = Math.max(result,mid);
                start= (int)(mid+1);
            }else if(mid*mid>num){
                end= (int)mid-1;
            }
        }
        return result*result==num? (int) result :-1;
    }
}
