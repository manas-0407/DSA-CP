package codeforce;

import java.util.*;

public class FairDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int one=0,two=0,x,i;
            for(i=0;i<n;i++)
            {
                x=sc.nextInt();
                if(x==1)
                    one++;
                else
                    two++;
            }
            int sum=two*2 + one;
            if(sum%2==0 && (two%2==0 || one>0))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
