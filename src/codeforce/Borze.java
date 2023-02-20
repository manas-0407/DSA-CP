package codeforce;

import java.util.*;

public class Borze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='.')
                System.out.print(0);
            else{
                i++;
                if(s.charAt(i)=='.')
                    System.out.print(1);
                else
                    System.out.print(2);
            }
        }
    }
}
