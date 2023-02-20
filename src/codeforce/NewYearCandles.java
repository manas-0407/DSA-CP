package codeforce;

import java.util.*;

public class NewYearCandles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        int carry=0,sum=0;
        while(a != 0){
            sum=sum+a;
            carry=carry+a%b;
            a=a / b;
            if(carry >= b)
            {
                a=a+carry/b;
                carry=carry%b;
            }
            //System.out.println(a);
           // System.out.println(carry);
        }
//        sum=sum+carry/b;
        System.out.println(sum);

    }
}
