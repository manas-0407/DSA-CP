package codeforce;

import java.util.*;

public class VasyaAndSocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int days=n,x=n/m ,y=0;
        while(x != y)
        {
           days=days +(x-y);
           x=days/m;
           y=n/m;
           n=days;
        }
        System.out.println(days);
    }
}
