package codeforce;

import java.util.*;

public class FoxAndSnake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        String s1="#",s2=".",s3="#";
        int i;
        for(i=2;i<m;i++)
        {
            s1=s1+"#";
            s2=s2+".";
            s3=s3+".";
        }
        s1=s1+"#";
        s2=s2+"#";
        s3=s3+".";
        for(i=1;i<=n;i++)
        {
            if(i%2==0)
            {
                if(i%4==0)
                    System.out.println(s3);
                else
                    System.out.println(s2);
            }
            else
                System.out.println(s1);
        }
    }
}
