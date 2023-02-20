package codeforce;

import java.util.*;

public class SumOfRoundNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int c,i,tenpow,rem;
        String s;
        while(t-->0)
        {
            c=0;
            s="";
            int n=sc.nextInt();
            i=0;
            tenpow=(int)Math.pow(10,i);
            while(n!=0)
            {
                rem=n%tenpow;
                if(rem!=0)
                {
                    s=s+rem+" ";
                    n=n-rem;
                    c++;
                }
                i++;
                tenpow=(int)Math.pow(10,i);
            }
            System.out.println(c+"\n"+s);
        }
    }
}
