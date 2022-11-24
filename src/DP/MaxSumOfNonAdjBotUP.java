package DP;

import java.util.*;
import java.io.*;

public class MaxSumOfNonAdjBotUP {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int i;
        for(i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(i=0;i<n;i++){
            if(i==0) {
                dp[1] = a[i];
                continue;
            }
            else if(i==1){
                dp[2] = Math.max(a[0] ,a[1]);
                continue;
            }
            int pick = a[i] + dp[i-1];
            int notpick = dp[i];
            dp[i+1] = Math.max(pick , notpick);
        }
        System.out.println(dp[n]);
    }
}
