package codeforce;

import java.util.*;

public class InterestingDrink {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n=sc.nextInt();
        int[] x=new int[n];
        int i;
        for (i=0;i<n;i++)
            x[i]=sc.nextInt();
        Arrays.sort(x);


        int q=sc.nextInt();
        int[] m=new int[q];
        for(i=0;i<q;i++)
            m[i] = sc.nextInt();


        int mid,l,h,ans;
        for(i=0;i<q;i++)
        {
            l=0;
            h=n-1;
            ans=-1;
            while(l<=h)
            {
                mid=l+(h-l)/2;
                        if(m[i]>=x[mid])
                        {
                            ans=mid;
                            l=mid+1;
                        }
                        else
                            h=mid-1;
            }
            System.out.println(ans+1);
        }
    }
}
