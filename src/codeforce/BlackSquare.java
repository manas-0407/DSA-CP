package codeforce;

import java.util.*;

public class BlackSquare {
    public static void main(String[] args) {
        int[] a=new int[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++)
            a[i]=sc.nextInt();
        String s=sc.next();
        int sum=0,n=s.length();
        while(n-- > 0)
        {
            sum=sum+a[(int)s.charAt(n)-49];
        }
        System.out.println(sum);
    }
}
