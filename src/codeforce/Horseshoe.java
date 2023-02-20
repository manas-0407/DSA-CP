package codeforce;
import java.util.*;
public class Horseshoe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a=new int[4];
        int c=0,i,j;
        for(i=0;i<4;i++)
        {
            a[i]=sc.nextInt();
        }
        for( i=0;i<4;i++)
        {
            if(a[i]>0) {
                for (j = i + 1; j < 4; j++) {

                    if (a[j] == a[i]) {
                        c++;
                        a[j] = -1;
                    }
                }
            }

        }
        System.out.println(c);
    }
}
