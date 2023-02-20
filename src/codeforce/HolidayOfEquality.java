package codeforce;

import java.util.*;

public class HolidayOfEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int i,max=0,sum=0;
        for(i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
            if(ar[i]>max)
                max=ar[i];
        }
        for(i=0;i<n;i++)
        {
            sum=sum+(max-ar[i]);
        }
        System.out.println(sum);
    }
}
