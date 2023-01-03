package Recursion_Problems;

import java.util.*;

public class OneToN {
    static void oneTon(int i, int n)
    {
        if(i==n+1)
            return;
        System.out.println(i);
        oneTon(i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        oneTon(1,n);
    }
}
