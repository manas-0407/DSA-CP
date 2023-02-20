package codeforce;


import java.util.Scanner;
import java.lang.*;
public class TheatreSq {
    public static void main(String[] args) {
        Scanner s =new Scanner (System.in);
        long n,m,a;
        n=s.nextLong();
        m=s.nextLong();
        a=s.nextLong();
        System.out.println((long)(Math.ceil((n*1.0)/a))  *  (long)(Math.ceil((m*1.0)/a)));
    }
}
