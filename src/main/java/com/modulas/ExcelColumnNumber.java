package com.modulas;

//Q1. Excel Column Number
//Solved
//feature icon
//Get your doubts resolved blazing fast with Chat GPT Help
//Check Chat GPT
//feature icon
//Using hints except Complete Solution is Penalty free now
//Use Hint
//Problem Description
//Given a column title as appears in an Excel sheet, return its corresponding column number.
//
//
//
//Problem Constraints
//1 <= length of the column title <= 5
//
//
//
//Input Format
//The only argument is a string that represents the column title in the excel sheet.
//
//
//
//Output Format
//Return a single integer that represents the corresponding column number.
//
//
//
//Example Input
//Input 1:
//
// AB
//Input 2:
//
// BB
//
//
//Example Output
//Output 1:
//
// 28
//Output 2:
//
// 54
//
//
//Example Explanation
//Explanation 1:
//
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28
//Explanation 2:
//
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28
// ...
// AZ -> 52
// BA -> 53
// BB -> 54
public class ExcelColumnNumber
{
    public static void main(String[] args) {
        System.out.println(new ExcelColumnNumber().titleToNumber("BB"));
    }
    public int titleToNumber(String A) {
        //#65 A 90 Z
        int len = A.length();
        int column=0;
        for (int i = 0; i < len; i++) {
            column += (A.charAt(i) - 'A' + 1) * power(26, len - 1 - i);
        }
        return column;
    }

    private static int power(int base,int exponent){
        long result = 1;
        long x = base;
        while(exponent>0){
            if(exponent%2==1){
                result*=x;
            }
            x*=x;
            exponent/=2;
        }
        return (int)result;
    }

}
