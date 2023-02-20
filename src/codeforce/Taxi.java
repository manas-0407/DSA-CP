package codeforce;
import java.util.*;
public class Taxi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i,s,sum=0;
        int[] ar=new int[4];
        for(i=0;i<n;i++) {
            s = sc.nextInt();
            ar[s-1]++;
        }
        sum=sum+ar[3];
        ar[3]=0;
        sum=sum+(ar[1]/2);
        ar[1]=ar[1]%2;
        if(ar[0]>=ar[2])
        {
            sum=sum+ar[2];
            ar[0]=ar[0]-ar[2];
            ar[2]=0;
            if(ar[1]==1)
            {
                if(ar[0]>1) {
                    sum++;
                    ar[1]=0;
                    ar[0] = ar[0] - 2;
                    sum=sum+(ar[0]/4);
                    ar[0]=ar[0]%4;
                    if(ar[0]!=0)
                        sum++;
                    ar[0]=0;
                }
                else
                {
                    sum++;
                    ar[1]=0;
                    ar[0]=0;
                }
            }
            else
            {
                sum=sum+(ar[0]/4);
                ar[0]=ar[0]%4;
                if(ar[0]!=0)
                    sum++;
                ar[0]=0;
            }
        }
        else if(ar[0]<ar[2])
        {
            sum=sum+ar[0];
            ar[2]=ar[2]-ar[0];
            ar[0]=0;
            sum=sum+ar[2];
            ar[2]=0;
            if(ar[1]==1)
            {
                sum++;
                ar[1]=0;
            }
        }
        System.out.println(sum);
//        ArrayList<Integer> s=new ArrayList<>(n);
//        for(i=0;i<n;i++)
//        {
//            s.add(sc.nextInt());
//            sum=sum+s[i];
//        }
//        //System.out.println((int)Math.ceil(sum/4.0));
//        Integer four=Integer.valueOf(4);
//        Integer three=Integer.valueOf(3);
//        Integer one=Integer.valueOf(1);
//        Integer two=Integer.valueOf(2);
//        while(s.remove(four))
//            sum++;
//
//        while(s.remove(three) && s.remove(one))
//        {
//            sum++;
//        }
//        if(s.contains(one))
//        {
//            while(s.remove(one)&&s.remove(one)&&s.remove(two))
//                sum++;
//
//        }
//        System.out.println(sum+s.size());
    }
}
