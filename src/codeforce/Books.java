package codeforce;

import java.util.*;

public class Books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int[] a=new int[n];
        int i;
        for(i=0;i<n;i++)
                a[i]= sc.nextInt();
        int l=0,r=0,sum=0;
        int maximum=Integer.MIN_VALUE;
        while(l<=r && r<n){
            sum += a[r];
//            r++;
//            if(sum<=t){
//                sum += a[r];
//
//
//            }
            while(sum > t){
                sum-=a[l];
                l++;
            }

//            System.out.println("sum: "+ sum);
//            System.out.println(l+" "+r);
            maximum=Math.max((r-l+1) , maximum);
//            System.out.println("Max: "+maximum);
            r++;
        }
        System.out.println(maximum);
    }
}
