package codeforce;
import java.util.*;
public class Magnets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,c=1,i;
        n=sc.nextInt();
        int[] a=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            if(i>0 && a[i]!=a[i-1])
            {
                c++;
            }
        }
        System.out.println(c);
    }
}
