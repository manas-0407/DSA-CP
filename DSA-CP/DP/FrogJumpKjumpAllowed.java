package DP;

import java.util.*;
import java.io.*;

public class FrogJumpKjumpAllowed {
    static int minFrogJ(int[] a,int[] dp,int n,int k){
        if(n==1) return dp[n] = 0;
        if(dp[n] != -1) return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k && i<n;i++){
            int Jump=minFrogJ(a,dp,n-i,k) + Math.abs(a[n-1] - a[n-1-i]);
            if(Jump < min) min=Jump;
        }
        return dp[n]=min;
    }

    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int [] a=new int[n];
        int i;
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(minFrogJ(a,dp,n,k));
    }
}
