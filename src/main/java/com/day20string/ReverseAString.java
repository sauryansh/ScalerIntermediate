package com.day20string;

public class ReverseAString {
    public static void main(String[] args) {
        //String s = "the sky is blue";
        String s =" bwroafq rfmy eimspekey w wnzjh qisjiabv ya hncn mazvb pfwlcsnkqz muiapt nnvwwx rp bsypbqu ymg bjwapykfil";
        System.out.println(new ReverseAString().solve(s));
    }

    public String solve(String s){
        //Trim space from front and back
        String s1 = s.trim();

        String[] words = s1.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
