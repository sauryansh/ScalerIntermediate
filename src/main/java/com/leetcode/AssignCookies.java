package com.leetcode;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{3};
        System.out.println(new AssignCookies().findContentChildren(g,s));
    }
        public int findContentChildren(int[] g, int[] s) {
            //Max of s
            int maxS=Integer.MIN_VALUE;
            for(int i=0;i<s.length;i++){
                if(s[i]>maxS){
                    maxS=Math.max(maxS,s[i]);
                }
            }
            System.out.println(maxS);

            Arrays.sort(g);
            int result = 0;
            for(int i=0;i<g.length;i++){
                if(g[i]<=maxS){
                    result++;
                    maxS-=g[i];
                }
            }
            return result;
        }
    }