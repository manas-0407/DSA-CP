package codeforce;
import java.util.*;
public class UltraFMaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next(),s2=sc.next();
        for(int i=0;i<s1.length();i++)
        {
            System.out.print(Math.abs((Character.getNumericValue(s1.charAt(i)))-(Character.getNumericValue(s2.charAt(i)))));
        }
    }
}
