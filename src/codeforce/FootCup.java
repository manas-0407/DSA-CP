package codeforce;
import java.util.*;
public class FootCup {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int t,x,y;
        t=sc.nextInt();
        while(t-->0)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            if(x>0 && y>0 && x==y)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
