package codeforce;
import java.util.*;
public class PoliceStation{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int[] a=new int[n];
        int i,c=0,j=0;
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(i=0;i<n;i++)
        {
            if(a[i]!=-1)
            {
                if(j<0)
                j=0;
                j=j+a[i];
            }
            else
            {
                if(j-- > 0)
                    c=c;
                else
                    c++;
            }
        }
        System.out.println(c);
    }
}
