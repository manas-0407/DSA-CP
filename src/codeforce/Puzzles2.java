package codeforce;

import java.util.*;
import java.io.*;

public class Puzzles2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[] ar=new int[m];
        int i,j,min,max,sum=Integer.MAX_VALUE;
        for (i = 0; i < m; i++) {
            ar[i]=sc.nextInt();
        }
        Arrays.sort(ar);
        //System.out.println(Arrays.toString(ar));
        for(i=0;i<=m-n;i++)
        {
           // System.out.println("Sum= "+sum);
            min=ar[i];
            max=ar[i];
            for(j=i;j<i+n;j++)
            {
                if(ar[j]<min)
                    min=ar[j];
           //     System.out.println("Min= "+min);
                if(ar[j]>max)
                    max=ar[j];
           //     System.out.println("Max= "+max);
            }
           // System.out.println(max-min);
            if(max-min < sum)
                sum=max-min;
        }
        System.out.println(sum);
    }
}
