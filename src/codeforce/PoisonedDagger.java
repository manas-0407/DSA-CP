package Codeforce;
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class PoisonedDagger {
    static boolean canKill(long k,long h,int[] a){
        long sum=0;
        for(int i=0;i<a.length;i++){
            if(i<a.length-1) sum+=Math.min(a[i+1]-a[i] , k);
            else sum+=k;
        }
        return sum>=h;
    }
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            long h=sc.nextLong();
            int i;
            int[] a=new int[n];
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}
            long l=1,r= (long) 1e18;
            while (l<r){
                long mid=l+(r-l)/2;
                if(canKill(mid,h,a)) r=mid;
                else l=mid+1;
            }
            out.println(r);
            out.flush();
    }
}