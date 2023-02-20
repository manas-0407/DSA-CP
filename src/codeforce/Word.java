package codeforce;
import java.util.*;
public class Word {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int i,u=0,l=0;
        for(i=0;i<s.length();i++)
        {
           if(s.charAt(i)>64 && s.charAt(i)<91)
               u++;
           else
               l++;
        }
        if(u>l)
            System.out.println(s.toUpperCase());
        else
            System.out.println(s.toLowerCase());
    }
}
