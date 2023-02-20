package codeforce;

import java.util.*;

public class EvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int[] a=new int[n];
            int co=0,ce=0,i,m=0;
            for(i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                if(m==0)
                {
                    if(a[i]%2!=0)
                        ce++;
                    m=1;
                }
                else
                {
                    if(a[i]%2!=1)
                        co++;
                    m=0;
                }
            }
            if(co==ce)
                System.out.println(co);
            else
                System.out.println(-1);
        }
    }
}
