package codeforce;

import java.util.*;

public class VasyaTheHipster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min,max,a=sc.nextInt(),b=sc.nextInt();
        if(a>b)
        {
            min=b;
            max=a;
        }
        else
        {
            min=a;
            max=b;
        }
        System.out.println(min+" "+(max-min)/2);
    }
}
