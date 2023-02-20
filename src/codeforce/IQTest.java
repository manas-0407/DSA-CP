package codeforce;

import java.util.*;
import java.io.*;

public class IQTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,n=sc.nextInt(),c=0;
        int [] a=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        if(a[0]%2!=a[1]%2 && a[0]%2!=a[2]%2) {
            System.out.println(1);
            c=1;
        }
        if(a[n-1]%2!=a[n-2]%2 && a[n-1]%2!=a[n-3]%2) {
            System.out.println(n);
            c=1;
        }
        for(i=1;i<n-1&&c!=1;i++)
        {
            if(a[i-1]%2==a[i+1]%2 && a[i]%2!=a[i-1]%2)
            {
                System.out.println(i+1);
                break;
            }
        }

    }
}
