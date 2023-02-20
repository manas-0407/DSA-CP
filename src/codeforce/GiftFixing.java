package codeforce;

import java.util.*;

public class GiftFixing {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int[] a=new int[n],b=new int[n];
            int i,mina=Integer.MAX_VALUE,minb=Integer.MAX_VALUE;
            for(i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                if(a[i]<mina)
                    mina=a[i];
            }
            for(i=0;i<n;i++) {
                b[i] = sc.nextInt();
                if (b[i] < minb)
                    minb = b[i];
            }
            long sum=0;
            int xa,xb,common;
            for(i=0;i<n;i++)
            {
                xa=a[i]-mina;
                xb=b[i]-minb;
                common=Math.min(xa,xb);
                sum=sum + common + (xa+xb-(common * 2));
            }
            System.out.println(sum);
        }
    }
}
