package DP;

import java.util.*;
import java.io.*;

// Top_Down Approach (Recursive)

public class HouseRobber {

    static int maxRob(int[] a,int[] dp,int n){

        if(n<=0) return dp[0] = 0;
        if(dp[n] != -1) return dp[n];
        int temp=a[0];
        a[0] = 0;
        int pick=a[n-1] + maxRob(a,dp,n-2);
        int notpick=maxRob(a,dp,n-1);
        int ans1=Math.max(pick,notpick);

        a[0] =temp;
        a[n-1]=0;
        pick = a[n-1] + maxRob(a,dp,n-2);
        notpick = maxRob(a,dp,n-1);
        int ans2 = Math.max(pick,notpick);

        return dp[n]=Math.max(ans1 ,ans2);
    }

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
        System.out.println(maxRob(a,dp,n));
    }
}
