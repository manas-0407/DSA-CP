package codeforce;
import java.util.*;
public class Bitpp {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int n,x=0;
        String s;
        n=sc.nextInt();
        while(n-->0)
        {
            s=sc.next();
            if(s.compareTo("++X")==0)
                ++x;
            else if(s.compareTo("X++")==0)
                x++;
            else if(s.compareTo("--X")==0)
                --x;
            else if(s.compareTo("X--")==0)
                x--;
        }
        System.out.println(x);
    }

}
