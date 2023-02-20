package codeforce;

import java.util.*;

public class XeniaAndRingroad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        int z,i,j=sc.nextInt();
        long step=j-1;
        for(z=1;z<m;z++)
        {

            // System.out.println("Step= "+step);
            i=sc.nextInt();
            if(i<j)
            {
                step=step + n-j;
                //System.out.println("Step in if 1= "+step);
                step=step + i;
                //System.out.println("Step in if= "+step);
            }
            else {
                //System.out.println(i+" "+j);
                step = step + i - j;
                //System.out.println(step);
            }

            j=i;
        }
        System.out.println(step);
    }
}
