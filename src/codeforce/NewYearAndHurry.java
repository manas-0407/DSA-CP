package codeforce;

import java.util.*;

public class NewYearAndHurry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        double x,t=240-k;
        t=t/2.5;
        double ans=(Math.sqrt(4*t + 1) - 1)/2;
        if(ans>n)
            System.out.println(n);
        else
            System.out.println((int)ans);
    }
}
