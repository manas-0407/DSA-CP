package codeforce;
import java.util.*;
public class WannaBeWinner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] al=new int[n];
        int p=sc.nextInt(),i,a,q;
        for(i=0;i<p;i++)
        {
            a=sc.nextInt();
            al[a-1]=1;
        }
        q=sc.nextInt();
        for(i=0;i<q;i++)
        {
            a=sc.nextInt();
            al[a-1]=1;
        }
        for(i=0;i<n;i++)
        {
            if(al[i]!=1)
                i=n+2;
        }
        if(i==n+3)
        System.out.println("Oh, my keyboard!");
        else
            System.out.println("I become the guy.");
    }
}
