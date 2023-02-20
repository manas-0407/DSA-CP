package codeforce;
import java.util.*;
public class VanyaAndFence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),h=sc.nextInt();
        int i,count=0;
        int[] a=new int [n];
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            if(a[i]>h)
                count+=2;
            else
                count++;
        }

        System.out.println(count);

    }
}

