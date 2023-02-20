package codeforce;

import java.util.*;

public class MinimalSq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int a= sc.nextInt();
            int b=sc.nextInt();
            int min=Math.min(a,b);
            b=a+b-min;
            a=min;
            if(a!=b)
            {
                if(2*a-b<0)
                    System.out.println(b*b);
                else
                    System.out.println(4*a*a);
            }
            else
                System.out.println(4*a*a);
        }
    }
}
