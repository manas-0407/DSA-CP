package codeforce;

import java.util.*;
import java.io.*;

public class AntonAndPolyhedrons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,c=0,n=sc.nextInt();
        String s;
        for(i=0;i<n;i++)
        {
            s=sc.next();
            if(s.charAt(0)=='T')
                c=c+4;
            if(s.charAt(0)=='C')
                c=c+6;
            if(s.charAt(0)=='O')
                c=c+8;
            if(s.charAt(0)=='D')
                c=c+12;
            if(s.charAt(0)=='I')
                c=c+20;
        }
        System.out.println(c);
    }
}
