package codeforce;
import java.util.*;
public class Bmatrix {
    public static void main(String[] args) {

        Scanner sc=new Scanner (System.in);
        int i,j,x=0,y = 0;
        int a[][]=new int[5][5];
        for(i=0;i<5;i++)
        {
            for(j=0;j<5;j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    x = i+1;
                    y = j+1;
                }
            }
        }
        System.out.println(Math.abs(3-x)+Math.abs(3-y));
    }
}
