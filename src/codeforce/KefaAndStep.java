package codeforce;
import java.util.*;
public class KefaAndStep {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,s=1,c=1,n=sc.nextInt();
        int[] a=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(i=1;i<n;i++)
        {

         if(a[i]>=a[i-1])
             s++;
         else
             s=1;
            if(s>c)
                c=s;
           // System.out.println(s);
            //System.out.println(c);
        }
        System.out.println(c);
    }
}
