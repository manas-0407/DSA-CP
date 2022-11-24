package DP;

import java.util.*;
import java.io.*;

public class MaxSumNonAdjc {

    static int maxAdjSum(int n,int[] a,int[] dp){
        if(n<1) return dp[0] = 0;
        if(n==1) return dp[n] = a[0];
        if(dp[n] != -1) return dp[n];
        int picked=0,not_pick;
        if(n>1) picked=a[n-1] + maxAdjSum(n-2,a,dp);
        not_pick = maxAdjSum(n - 1, a, dp);
        return dp[n] = Math.max(picked,not_pick);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int i;
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(maxAdjSum(n,a,dp));
    }
}
