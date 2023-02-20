package codeforce;
import java.util.*;
public class Drinks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] p=new int[n];
        double sum=0;
        for(int i=0;i<n;i++)
        {
            p[i]=sc.nextInt();
            sum=sum+p[i];
        }
        System.out.println(sum/n);
    }
}
