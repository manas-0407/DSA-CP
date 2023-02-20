package codeforce;
import java.util.*;
public class InsomniaCure {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt(),c=0,l=sc.nextInt(),m=sc.nextInt(),n= sc.nextInt(),d=sc.nextInt();
        for(int i=1;i<=d;i++)
        {
            if(i%k==0|| i%l==0|| i%m==0|| i%n==0)
                c++;
        }
        System.out.println(c);
    }
}
