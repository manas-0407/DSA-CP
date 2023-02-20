package codeforce;

import java.util.*;
import java.io.*;

public class VanyaAndLanterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,n=sc.nextInt(),l=sc.nextInt();
        int[] a=new int[n];
        for(i=0;i<n;i++)
            a[i]=sc.nextInt();
        Arrays.sort(a);
        double t=Math.max(a[0],l-a[n-1]),x;
        for(i=0;i<n-1;i++)
        {
            x=(a[i+1]-a[i])/ 2.0;
            if(x > t)
                t=x;
        }
        System.out.println(String.format("%.9f",t));
    }
}
