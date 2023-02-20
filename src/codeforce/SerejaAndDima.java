package codeforce;

import java.util.*;

public class SerejaAndDima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int ssum=0,dsum=0,toggle=0,start=0,end=n-1;
        while(start<=end)
        {
            if(toggle==0)
            {
                if(a[start] < a[end])
                {
                    ssum=ssum+a[end];
                    end--;
                }
                else
                {
                    ssum=ssum+a[start];
                    start++;
                }
                toggle=1;
            }
            else
            {
                if(a[start] < a[end])
                {
                    dsum=dsum+a[end];
                    end--;
                }
                else
                {
                    dsum=dsum+a[start];
                    start++;
                }
                toggle=0;
            }
        }
        System.out.println(ssum+" "+dsum);
    }
}
