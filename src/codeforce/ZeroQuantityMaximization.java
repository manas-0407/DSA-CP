package codeforce;

import java.util.*;

public class ZeroQuantityMaximization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        int i,bothzero=0;
        double d;
        for(i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(i=0;i<n;i++)
            b[i]=sc.nextInt();

        AbstractMap<Double,Integer> hm= new HashMap<>();

        for(i=0;i<n;i++)
        {
            if(a[i]==0 && b[i]==0)
            {
                bothzero ++;
                continue;
            }
            d= (-1.0*b[i]) / a[i];
            if(b[i]==0)
                d=Math.abs(d);
            //System.out.println(d);
            if(! hm.containsKey(d))
            {
                hm.put(d,1);
            }
            else
            {
                hm.put(d,hm.get(d)+1);
            }
        }

        int max=0;

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(hm);
        System.out.println(1.0/0);

        for(Map.Entry<Double,Integer> entry : hm.entrySet())
            if(entry.getKey() !=1.0/0 && entry.getKey() != -1.0/0 && entry.getValue() > max)  max=entry.getValue();
        System.out.println(max+bothzero);
    }
}
