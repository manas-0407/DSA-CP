package codeforce;
import java.util.*;
public class NextRound {
    public static void main(String[] args) {
        Scanner s=new Scanner (System.in);
        int n,k,i,count;
        n=s.nextInt();
        k= s.nextInt();
        int[] a=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        if(a[0]!=0) {
            count=k;
            for(i=k-1;i>0;i--)
            {
                if(a[i]==0)
                    count--;
            }
            for (i =k; i < n; i++) {
                if (a[i] == a[k - 1] && a[i]!=0)
                    count++;
            }
        }
        else
            count=0;
        System.out.println(count);
    }
}
