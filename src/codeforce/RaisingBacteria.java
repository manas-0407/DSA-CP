package codeforce;

import java.util.*;

public class RaisingBacteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int count=0;
        while(x!=0)
        {
            x=x&(x-1);
            count++;
        }
        System.out.println(count);
    }
}
