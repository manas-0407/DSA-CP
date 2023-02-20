package codeforce;
import java.util.*;
public class StoneOnTable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t,i,n;
        n=sc.nextInt();
        String s=sc.next();
        t=0;
        for(i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                t++;
        }
        System.out.println(t);
    }
}
