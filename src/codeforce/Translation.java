package codeforce;
import java.util.*;
public class Translation {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        String s=sc.next(),t=sc.next(),sr="";
        for(int i=s.length()-1;i>=0;i--)
            sr=sr + s.charAt(i);

         if(sr.compareTo(t)==0)
             System.out.println("YES");
         else
             System.out.println("NO");
    }
}
