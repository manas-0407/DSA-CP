package codeforce;

import java.util.*;

public class BersuBall2Ptr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int i,j,count=0;
        for(i=0;i<n;i++)
            a[i]= sc.nextInt();
        int m=sc.nextInt();
        int[] b=new int[m];
        for(j=0;j<m;j++)
            b[j]=sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);
        i=0;j=0;
        while(i<n && j<m){
            if(Math.abs(a[i] - b[j]) <=1) {
                count++;
                i++;
                j++;
//                for(i=1;i<n;i++) if(a[i] != a[i-1]) break;
//                for(j=1;j<m;j++) if(b[j] != a[j-1]) break;
                if(a[i]!=a[i-1] || b[j]!=b[j-1]) {
                    System.out.println(a[i]+" "+b[j]);
                    count--;
                }
                i++;
                j++;
            }
            else if(a[i] < b[j]) i++;
            else j++;
        }
        System.out.println(count);
    }
}
