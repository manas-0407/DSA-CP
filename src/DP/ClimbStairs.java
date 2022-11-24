package DP;

import java.util.*;
import java.io.*;
public class ClimbStairs {

    static int stairCt(int n, int[] dp){
        System.out.println(Arrays.toString(dp));
        if(n<=1) return dp[n]=1;
        if(dp[n] != -1 )return dp[n];
        return dp[n] = stairCt(n-1,dp) + stairCt(n-2,dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(stairCt(n,dp));
    }
}
