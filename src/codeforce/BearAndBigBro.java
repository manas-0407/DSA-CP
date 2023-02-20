package codeforce;
import java.util.*;
public class BearAndBigBro {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b,i;
        a=sc.nextInt();
        b=sc.nextInt();
//        p1=3*a;
//        p2=2*b;
        for(i=1;i>0;i++)
        {

         if(a*Math.pow(3,i) > b*Math.pow(2,i))
         {
             System.out.println(i);
             break;
         }
        }
    }
}
