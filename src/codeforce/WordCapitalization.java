package codeforce;
import java.util.*;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        if(s.charAt(0)>64 && s.charAt(0)<91)
            System.out.println(s);
        else
            System.out.println((char)(s.charAt(0)-32) + s.substring(1,s.length()));
    }
}
