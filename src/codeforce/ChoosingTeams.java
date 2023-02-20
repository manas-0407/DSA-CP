package codeforce;

import java.util.*;

public class ChoosingTeams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int i,x,c=0;
        for(i=0;i<n;i++)
        {
            x=sc.nextInt();
            if(5-x >= k)
                c++;
        }
        System.out.println(c/3);
    }
}
