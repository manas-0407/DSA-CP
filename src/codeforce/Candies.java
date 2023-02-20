package codeforce;

import java.util.*;

public class Candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = 2;
            while (true) {
                if (n % ((1 << k) - 1) == 0) {
                    System.out.println(n / ((1 << k) - 1));
                    break;
                }
                k++;
            }
        }
    }
}
