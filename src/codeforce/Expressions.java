package codeforce;
import java.util.*;
public class Expressions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),r;
        if(a==1 || c==1)
        {
            r=(a==c) ? a+b+c : a>c?a*(b+c):(a+b)*c;
        }
        else
            r=(b==1) ? (a>c?a*(b+c) : (a+b)*c)  :  a*b*c;
        System.out.println(r);
    }
}
