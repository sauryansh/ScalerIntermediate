package com._3bit;

public class AddString {
    public static void main(String[] args) {
        AddString addString = new AddString();
        System.out.println(addString.addBinary("100","11"));
    }

    public String addBinary(String A, String B) {
        char [] a = A.toCharArray();
        char [] b = B.toCharArray();

/*        System.out.println(a);
        System.out.println(b);*/

        int i = a.length-1;
        int j = b.length-1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum+=a[i]-'0';
                i--;
            }
            if(j>=0){
                sum+=b[j]-'0';
                j--;
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
