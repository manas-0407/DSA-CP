package codeforce;

import java.util.*;

public class MulBy2DivBy6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int count=0;
            boolean b=true;
            while(n!=1 && b) {
                if (n % 6 == 0) {
                    count++;
                    n /= 6;
                } else {
                    while (b) {
                        n = n << 1;
                        count++;
                        if (n % 6 == 0) break;
                        if(n>1000000000) b=false;
                    }
                }
            }
            if(!b) System.out.println(-1);
            else System.out.println(count);
        }
    }
}
