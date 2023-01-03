package Recursion_Problems;

import java.util.*;

public class StringSubset {
    static void recSubset(String s, int k)
    {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        recSubset(s,2<<(n-1));
    }
}
