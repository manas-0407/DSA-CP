package codeforce;

import static java.lang.System.out;

import java.util.*;

public class TTGame2 {

public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //sc.run(); //-->Uncomment to print debug result in error.txt file and not on console
        int k=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        if((a<k && b<k) || (b<k&&a%k!=0) || (a<k&&b%k!=0)) out.println(-1);
        else {
            out.println(a/k+b/k);
        }
    }
}
