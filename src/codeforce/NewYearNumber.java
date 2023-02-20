package codeforce;

import java.util.*;

public class NewYearNumber {
    static boolean isInteger(double d){
//        double d=y*1.0;
        return d / 2021 == Math.floor(d / 2021);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            double y,x=0;
            while( x*2020 <= n ){
             y = n- x*2020;
             if(isInteger(y)){
                 System.out.println("YES");
                 break;
             }
             x++;
            }
            if(x*2020 > n) System.out.println("NO");
        }
    }
}
