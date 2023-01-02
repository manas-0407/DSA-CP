package Dynamic_Programming;

import java.util.*;

public class Fibo {

    static int fib(int n,int[] dp){
        if(n==0){
            return dp[n]=0;
        }
        if(n<=2){
            return dp[n] = n-1;
        }
        if(dp[n] != -1) return dp[n];
        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
//        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        long sttime = System.currentTimeMillis();
        int x=(fib(n,dp));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
    }
}
