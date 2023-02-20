package codeforce;

import java.util.*;

public class NewYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x=new int[3];
        x[0]=sc.nextInt();
        x[1]=sc.nextInt();
        x[2]=sc.nextInt();
        Arrays.sort(x);
        System.out.println(x[2] - x[0]);
    }
}
