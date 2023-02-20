package codeforce;

import java.util.*;

public class KthNotDivByN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int x=1,z=k,y=0;
            while(x!=0){
                x=k/n;
                y=y+x;
                z=z+x;
                k=z-y*n;
            }
            System.out.println(z);
        }

    }
}
