package Recursion_Problems;

import java.util.*;

public class RopeCutting {

    static int  max(int a,int b,int c)
    {
        if(a>b)
        {
            if(a>c)
                return a;
            else
                return c;
        }
        else
        {
            if(b>c)
                return b;
            else
                return c;
        }
    }
    static int rc(int n,int a,int b,int c)
    {
        if(n==0)
            return 0;
        if(n<0)
            return -1;
        int maxres=max(rc(n-a, a, b, c),rc(n-b,a,b,c),rc(n-c,a,b,c));
        if(maxres==-1)
            return -1;
        return maxres+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,a,b,c;
        n=sc.nextInt();
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        System.out.println(rc(n,a,b,c));
    }
}
