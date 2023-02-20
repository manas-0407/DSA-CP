package codeforce;
import java.util.*;
public class SearchOfEasy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,c=0,n=sc.nextInt();
        int[] a=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            if(a[i]==1)
                c=1;
        }
        if(c==1)
            System.out.println("HARD");
        else
            System.out.println("EASY");
    }
}
