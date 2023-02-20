package codeforce;
import java.util.*;
public class Hulk {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,n=sc.nextInt();
        System.out.print("I hate");
        for(i=1;i<=n-1;i++)
        {
            if(i%2!=0)
                System.out.print(" that I love");
            else
                System.out.print(" that I hate");
        }

        System.out.println(" it");
    }
}