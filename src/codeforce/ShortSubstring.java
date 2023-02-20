package codeforce;

import java.util.*;

public class ShortSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            String s=sc.next();
            System.out.print(s.charAt(0));
            for(int i=1;i<s.length()-1;i=i+2)
            {
                System.out.print(s.charAt(i));
            }
            System.out.println(s.charAt(s.length()-1));
        }
    }
}
