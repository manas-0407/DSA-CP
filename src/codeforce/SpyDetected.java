package codeforce;

import java.util.*;

public class SpyDetected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] a=new int[n];
            int i;
            for(i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            int find=0;
            if(a[0]!=a[1] && a[0]!=a[2])
                find=0;
            else if(a[n-1]!=a[n-2] && a[n-1]!=a[n-3])
                find=n-1;
            else {
                for (i = 1; i < n - 1; i++) {
                    if (a[i] != a[i - 1] && a[i] != a[i + 1])
                        find = i;
                }
            }
            System.out.println(find+1);
        }
    }
}
