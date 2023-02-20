package codeforce;

import java.util.*;

public class BerSu_Ball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] b=new int[n];
        int i,gdata;
        for(i=0;i<n;i++)
             b[i]=sc.nextInt();

        int m=sc.nextInt();
        Map<Integer,Integer> ghash = new HashMap<>();
        for(i=0;i<m;i++)
         {
             gdata=sc.nextInt();
             if( !ghash.containsKey(gdata))
                 ghash.put(gdata,1);
             else
                 ghash.put(gdata, ghash.get(gdata)+1);
         }

         int count=0,x;
         for(i=0;i<n;i++)
         {
             if(ghash.containsKey(b[i]))
             {
                 count++;
                 x=ghash.get(b[i]);
                 if(x==1)
                     ghash.remove(b[i]);
                 else
                    ghash.put(b[i], x-1);
             }
             else if(ghash.containsKey(b[i]+1))
             {
                 count++;
                 x=ghash.get(b[i]+1);
                 if(x==1)
                     ghash.remove(b[i]+1);
                 else
                    ghash.put(b[i]+1, x-1);
             }
             else if(ghash.containsKey(b[i]-1))
             {
                 count++;
                 x=ghash.get(b[i]-1);
                 if(x==1)
                     ghash.remove(b[i]-1);
                 else
                    ghash.put(b[i]-1, x-1);
             }
         }

         System.out.println(count);
    }
}
