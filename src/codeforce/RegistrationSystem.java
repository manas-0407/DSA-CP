package codeforce;

import java.util.*;


public class RegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n];
        int i,j,z;
        for(i=0;i<n;i++)
        {
            s[i]=sc.next();
        }
        for(i=0;i<n;i++)
        {
            z=0;
            for(j=0;j<i;j++)
            {
                if(s[j].compareTo(s[i])==0)
                {
                    z++;
                }
            }
            if(z>0)
                System.out.println(s[i]+z);
            else
                System.out.println("OK");
        }
    }
}
