package Recursion_Problems;

import java.util.*;

public class NtoOne {
    static void ntoone(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        ntoone(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ntoone(n);
    }
}
