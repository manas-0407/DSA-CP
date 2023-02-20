package codeforce;

import java.util.*;

public class Sales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n];
        int i;
        for(i=0;i<n;i++)
            a[i] =sc.nextInt();
        Arrays.sort(a);
        int sum=0;
        for(i=0;i<m && a[i]<0;i++){
            if(a[i] < 0) sum+= -1*a[i];
        }
        System.out.println(sum);
    }
}
