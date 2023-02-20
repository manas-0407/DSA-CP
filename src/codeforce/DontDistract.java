package codeforce;

import java.util.*;

public class DontDistract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt(),i;
            String s=sc.next();
            for (i=0;i<n-1;i++)
            {
                if(s.charAt(i)==s.charAt(i+1))
                    continue;
                else if(i==s.lastIndexOf(s.charAt(i)))
                    continue;
                else
                {
                    System.out.println("NO");
                    break;
                }
            }
            if(i==n-1)
                System.out.println("YES");
        }
    }
}
