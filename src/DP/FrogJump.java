package DP;

import java.util.*;
import java.io.*;

public class FrogJump {

    static int frogJ(int n,int[] a,int[] dp){
//        System.out.println(Arrays.toString(dp));
        System.out.println();
        if(n==1) return dp[n]=0;
        if(n==2) return dp[2]=Math.abs(a[1] - a[0]);
        if(dp[n] != -1 ) return dp[n];
        int J1=frogJ(n-1,a,dp) + Math.abs(a[n-1] - a[n-2]);
        int J2=frogJ(n-2,a,dp) + Math.abs(a[n-1] - a[n-3]);
        return dp[n] = Math.min(J1,J2);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a =new int[n];
        int i ;
         for(i=0;i<n;i++){
             a[i]=sc.nextInt();
         }
         int[] dp=new int[n+1];
         Arrays.fill(dp,-1);
        System.out.println(frogJ(n,a,dp));
    }
}
