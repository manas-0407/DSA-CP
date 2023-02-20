package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DieRoll {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int w = sc.nextInt();
        y = (y > w) ? 7 - y : 7 - w;
        w = gcd(y, 6);
        System.out.println(y / w + "/" + 6 / w);
    }
}
