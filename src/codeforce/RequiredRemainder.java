package codeforce;

import java.util.*;

public class RequiredRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            int n=sc.nextInt();
            int q=(int)Math.floor((n-y)/(x*1.0));
            System.out.println(q*x+y);
        }
    }
}
