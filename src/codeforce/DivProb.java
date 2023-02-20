package codeforce;
import java.util.*;
public class DivProb {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b,x,t=sc.nextInt();
        while(t-->0)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            x=a%b;
            if(x==0)
                System.out.println(0);
            else
                System.out.println(b-x);
        }
    }
}
