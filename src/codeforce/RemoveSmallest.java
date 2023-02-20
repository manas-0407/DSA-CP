package codeforce;

import java.util.*;

public class RemoveSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(),n,i;
        while(t-- >0)
        {
            n=sc.nextInt();
            int[] a=new int[n];
            for(i=0;i<n;i++)
                a[i]=sc.nextInt();
            Arrays.sort(a);
            for(i=1;i<n;i++)
            {
                if(Math.abs(a[i]-a[i-1])>1.0)
                {
                    System.out.println("NO");
                    break;
                }
            }
            if(i==n)
                System.out.println("YES");
        }
    }
}
