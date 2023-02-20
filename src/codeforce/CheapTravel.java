package codeforce;

import java.util.*;

public class CheapTravel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,a,b;
        n=sc.nextInt();
        m= sc.nextInt();
        a= sc.nextInt();
        b=sc.nextInt();
        int sum;
        System.out.println((b*1.0)/m+"  "+(a*1.0));
        if((b*1.0)/m <= (a*1.0)) {
            sum = (n / m) * b;
            if (b < (n % m) * a)
                sum = sum + b;
            else
                sum = sum + (n % m) * a;
        }
        else
            sum=n*a;
        System.out.println(sum);
    }
}
