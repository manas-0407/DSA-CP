package codeforce;

import java.util.*;

public class IIyaaAndBankAc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        if(n>=0)
            System.out.println(n);
        else
        {
            n=n*-1;
            if(n%10 > (n%100)/10)
                System.out.println(n/10 * -1);
            else
            {
             int t=n%10;
             n=n/100;
             n=n*10 + t;
                System.out.println(-1*n);
            }
        }
    }
}
