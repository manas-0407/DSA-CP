package codeforce;

import java.util.*;

public class ArrayCloningTech {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int[] a=new int[n];
            int i,y;
            for(i=0;i<n;i++)
                a[i]=sc.nextInt();
            HashMap<Integer , Integer> hm=new HashMap<>();
            int max=1;
            for(i=0;i<n;i++) {
                if (hm.get(a[i]) == null)
                    hm.put(a[i], 1);
                else {
                    y=hm.get(a[i]);
                    hm.put(a[i], ++y);
                    if(y>max)
                        max=y;
                }
            }
            if(hm.size()==1) {
                System.out.println(0);
                continue;
            }
            int sum=0,clone=0,k;
            i=0;
            while(true)
            {
                clone++;
                k=max*(1<<i);
                if(2*k >= n){
                    sum=sum + n-k;
                    break;
                }

                sum += k;
                i++;
            }
            System.out.println(sum+clone);
        }
    }
}
