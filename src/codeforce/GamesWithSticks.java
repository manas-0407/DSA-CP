package codeforce;

import java.util.*;

public class GamesWithSticks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),c=0;
        while(n>0 && m>0)
        {
            c++;
            n--;
            m--;
        }
        if(c%2==0)
            System.out.println("Malvika");
        else
            System.out.println("Akshat");
    }
}
