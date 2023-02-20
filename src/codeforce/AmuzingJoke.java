package codeforce;

import java.util.*;
import java.io.*;

public class AmuzingJoke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a=sc.next()+sc.next(),b=sc.next();
        if(a.length()!=b.length())
        {
            System.out.println("NO");
        }
        else
        {
            char[] c1,c2;
            c1=a.toCharArray();
            c2=b.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            int i;
            for(i=0;i<a.length();i++)
            {
                if(c1[i]!=c2[i])
                {
                    System.out.println("NO");
                    break;
                }
            }
            if(i==a.length())
                System.out.println("YES");
        }
    }
}
