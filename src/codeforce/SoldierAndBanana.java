package codeforce;
import java.util.*;
public class SoldierAndBanana {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k,w;
        k=sc.nextInt();
        long n=sc.nextLong();
        w=sc.nextInt();
        if(((k*w*w + w*k)/2 - n)>0)
            System.out.println((k*w*w + w*k)/2 - n);
        else
        System.out.println(0);
    }
}
