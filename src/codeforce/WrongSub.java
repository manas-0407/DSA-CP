package codeforce;
import java.util.*;
public class WrongSub {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,k,t;
        n=sc.nextInt();
        k=sc.nextInt();
//        while(k!=0)
//        {
//            t=n%10;
//            if(t==0)
//            {
//                k--;
//                n/=10;
//            }
//            else
//            {
//                k=k-t;
//                n=n-t;
//
//            }
//        }
        while(k!=0)
        {
            t=n%10;
            if(k>t)
            {
                k=k-1-t;
                n/=10;
            }
            else {
                n = n - k;
                break;
            }
        }
        System.out.println(n);
    }
}
