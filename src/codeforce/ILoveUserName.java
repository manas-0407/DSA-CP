package codeforce;

import java.util.*;

public class ILoveUserName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int min=x,max=x,i,count=0;
        for(i=1;i<n;i++)
        {
            x=sc.nextInt();
            if(x<min)
            {
                count++;
                min=x;
            }
            if(x>max)
            {
                count++;
                max=x;
            }
        }
        System.out.println(count);
    }
}
