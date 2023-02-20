package codeforce;

import java.util.*;
import java.io.*;

public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,n=sc.nextInt();
        String s=sc.next();
        s=s.toLowerCase();
        int[] ar=new int[26];
        for(i=0;i<n;i++)
        {
            ar[s.charAt(i)-97]++;
        }
        for(i=0;i<26;i++)
        {
            if(ar[i]==0)
            {
                System.out.println("NO");
                break;
            }
        }
        if(i==26)
            System.out.println("YES");
    }
}
