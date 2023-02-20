package codeforce;
import java.util.*;
public class HQ9plus {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char c;
        int i;
        for( i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            if(c=='H'||c=='Q'||c=='9')
            {
                System.out.println("YES");
                break;
            }
        }
        if(i==s.length())
            System.out.println("NO");
    }
}
