package codeforce;

import java.util.*;

public class TwoArrayAndSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n,k;
            n=sc.nextInt();
            k=sc.nextInt();
            int[] a,b;
            a=new int[n];
            b=new int[n];
            int i;

            for(i=0;i<n;i++)
                a[i]=sc.nextInt();

            for(i=0;i<n;i++)
                b[i]=sc.nextInt();

            Arrays.sort(a);
            Arrays.sort(b);

            i=0;
            int j=n-1,sum=0;
            while(k>0 && a[i] < b[j])
            {
                sum=sum+b[j];
                j--;
                i++;
                k--;
            }
            while(i<n)
            {
                sum=sum+a[i];
                i++;
            }
            System.out.println(sum);
        }
    }
}
