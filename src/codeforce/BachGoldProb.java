package codeforce;

import java.util.*;

public class BachGoldProb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder str = new StringBuilder();
        int x;
        if (n % 2 == 0) {
            x = n / 2;
            str.append(x+"\n");
            while (x-- > 0)
                str.append(2+" ");
        } else {
            x = (n - 3) / 2;
            str.append((x+1)+"\n");
            while (x-- > 0)
                str.append(2+" ");
            str.append(3);
        }
        System.out.println(str);
    }
}
