package codeforce;

import java.util.*;

public class SoftDrinking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int l=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int p=sc.nextInt();
        int nl=sc.nextInt();
        int np=sc.nextInt();
        int min=(k*l)/nl;
        if(min>c*d)
            min=c*d;
        if(min>(p/np))
            min=p/np;
        System.out.println(min/n);
    }
}
