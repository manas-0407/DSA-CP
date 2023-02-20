package codeforce;

import java.util.*;

public class MeetingOnTheLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int[] x=new int[n];
            int i;
            int[] dt =new int[n];
            double sum=0;
            for(i=0;i<n;i++) {
                x[i] = sc.nextInt();
            }
            for(i=0;i<n;i++) {
                dt[i] = sc.nextInt();
            }
            if(n==1) {
                System.out.println(0);
                continue;
            }
            for (i=0;i<n;i++) sum += x[i] + dt[i];
            System.out.println(sum);
            sum = sum / n;
            System.out.println(sum);
            System.out.println();
        }
    }
}
