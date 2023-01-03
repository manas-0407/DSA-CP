package Recursion_Problems;

import java.util.*;

public class NaturalNoSum {
    int recsum(int n)
    {
        if(n==1)
            return n;
        return n+recsum(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        NaturalNoSum ns=new NaturalNoSum();
        int sum=ns.recsum(n);
        System.out.println(sum);
    }
}
