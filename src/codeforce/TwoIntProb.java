package codeforce;

import java.util.*;

public class TwoIntProb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t,a,b;
        t=sc.nextInt();
        while(t-- >0)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            int x=Math.abs(a-b);
            System.out.println((int)Math.ceil(x/10.0));
        }
    }
}
