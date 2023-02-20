package codeforce;

import java.util.*;

public class PolycarpAndCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(), n, x;
        while (t-- > 0){
            n=sc.nextInt();
            x=n%3;
            if(x == 2)
                System.out.println((n-x)/3 + " " + ((n-x)/3+1));
            else if(x == 1)
                System.out.println(((n-x)/3 + 1) + " " + (n-x)/3);
            else
                System.out.println(n/3 + " " + n/3);
        }
    }
}
