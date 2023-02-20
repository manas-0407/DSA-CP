package codeforce;
import java.util.*;
public class EvenOddss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), k = sc.nextLong();
        if (k <= Math.ceil(n / 2.0)) {
            System.out.println(k * 2 - 1);
        } else {

            System.out.println((long) (k - Math.ceil(n / 2.0)) * 2);
        }
    }
}
