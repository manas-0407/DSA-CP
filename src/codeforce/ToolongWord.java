package codeforce;

import java.util.Scanner;

public class ToolongWord {
    public static void main(String[] args) {

       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       while(t-->0) {
           String s = sc.next();
           if(s.length()>10)
           {
               System.out.print(s.charAt(0));
               System.out.print(s.length()-2);
               System.out.print(s.charAt(s.length()-1));
           }
           else
               System.out.println(s);
       }
    }
}
