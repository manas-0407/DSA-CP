package Recursion_Problems;

import java.util.*;

public class DigitSum {
    static int digisum(int n)
    {
        if(n<10)
            return n;
        return n%10+digisum(n/10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int sum=digisum(n);
        System.out.println(sum);
    }
}
