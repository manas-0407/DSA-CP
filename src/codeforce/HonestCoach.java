package codeforce;

import java.util.*;

public class HonestCoach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int[] s=new int[n];
            int i;
            for(i=0;i<n;i++)
                s[i]=sc.nextInt();
            Arrays.sort(s);
            int min=s[1]-s[0];
            for(i=2;i<n;i++)
            {
                if((s[i]-s[i-1]) < min)
                    min=s[i]-s[i-1];
            }
            System.out.println(min);
        }
    }
}
