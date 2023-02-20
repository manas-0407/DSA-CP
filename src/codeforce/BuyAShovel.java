package codeforce;

import java.util.*;

public class BuyAShovel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=sc.nextInt(),r=sc.nextInt();
        int i=1;
        while (true)
        {
           int x=k*i;
           if(x%10==0)
               break;
           else if((x-r)%10 ==0)
           break;
           i++;
        }
        System.out.println(i);
    }
}
