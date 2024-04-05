package com._1intro;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        armstrongNumber.printArmStrongIfAny(1000000000 );
    }

    public void printArmStrongIfAny(int n){
        for (int i=1;i<=n;i++){
            if(isArmstrong(i)){
                System.out.println(i);
            }
        }
    }

    public boolean isArmstrong(int n){
        int sum = 0;
        int temp = n;
        while(temp>0){
            int rem = temp%10;
            sum+=rem*rem*rem;
            temp/=10;
        }
        return sum == n;
    }
}
