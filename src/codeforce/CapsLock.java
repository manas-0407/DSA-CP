package codeforce;
import java.util.*;
public class CapsLock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int c=0;
        for(int i=1;i<s.length();i++)
        {
            if(Character.isLowerCase(s.charAt(i)))
                c=1;
        }
        if(c==0 && Character.isLowerCase(s.charAt(0)))
            System.out.println(Character.toUpperCase(s.charAt(0))+s.substring(1).toLowerCase());
        else if(c==1)
            System.out.println(s);
        else
            System.out.println(s.toLowerCase());
    }
}
