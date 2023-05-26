 package Codeforce;

import java.util.*;
import java.io.*;
public class MiddleClass {
    public static void main(String[] args)throws IOException {
        FileReader fr=new FileReader("C:\\Users\\manas\\Desktop\\TC6Q4.txt");
        Scanner sc=new Scanner(fr);
//        int t=sc.nextInt();
//        while (t-- > 0){
            int n=sc.nextInt();
            int[] a=new int[n];
            int i;
            int x=sc.nextInt(),max=0;
            long sum=0;
            for(i=0;i<n;i++) {
                a[i]=sc.nextInt();
                sum+=a[i];
                max+=(a[i]>=x?1:0);
                 System.err.println(i);
            }
            System.err.println(n+" "+x);
            Arrays.sort(a);
            for(i=0;i<n;i++){
                max= Math.max(max,sum/(n-i)>=x?(n-i):-1);
                sum-=a[i];
            }
            System.out.println("ans: "+max);
//        }
    }
}