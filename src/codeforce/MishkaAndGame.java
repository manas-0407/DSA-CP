package codeforce;

import java.util.*;

public class MishkaAndGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m,c,tm=0,tc=0;
       for(int i=0;i<n;i++)
       {
           m=sc.nextInt();
           c=sc.nextInt();
           if(m>c)
               tm++;
           if(c>m)
               tc++;
       }
       if(tm>tc)
           System.out.println("Mishka");
       else if(tm<tc)
           System.out.println("Chris");
       else
           System.out.println("Friendship is magic!^^");
    }
}
