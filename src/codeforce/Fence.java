package codeforce;

import java.util.*;

public class Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        int i,sum,initialsum=0,indexholder=1;
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(i<k) initialsum+=arr[i];
        }
        sum=initialsum;
        for(i=k;i<n;i++){
            sum=sum-arr[i-k] + arr[i];
            if(sum <= initialsum){
                initialsum = sum;
                indexholder = i-k+2;
//                System.out.println("Posi "+i);
//                System.out.println(initialsum);
//                System.out.println(indexholder);
            }
        }
        System.out.println(indexholder);
    }
}
