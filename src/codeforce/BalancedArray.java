package codeforce;

import java.util.*;

public class BalancedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0)
        {
            int n=sc.nextInt();
            if((n/2)%2!=0)
            {
                System.out.println("NO");
            }
            else
            {
                System.out.println("YES");
                int sum=0;
                String s="";
                for(int i=2;i<=n;i+=2) {
                    s=s+i+" ";
                    //System.out.print(i + " ");
                    sum=sum+i;
                }
                for(int i=1;i<=n/2;i++)
                {
                    int z=2*i - 1;
                    if(i==n/2)
                    {
                        s=s+sum;
                        //System.out.println(sum);
                    }
                    else
                    {
                        s=s+z+" ";
                        //System.out.print(z+" ");
                        sum=sum-z;
                    }
                }
                System.out.println(s);
            }
        }
    }
}
