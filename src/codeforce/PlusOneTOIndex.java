package codeforce;

import java.util.*;

public class PlusOneTOIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int[] a=new int[n];
            int i;
            for(i=0;i<n;i++)
                a[i]=sc.nextInt();
            Arrays.sort(a);
            System.out.println(a[n-1]-a[0]);

        }
    }
}
