package codeforce;

import java.util.*;

public class Planets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int c=sc.nextInt();
            int i;
            int[] a=new int[n];
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(i=0;i<n;i++) {
                a[i] = sc.nextInt();
                if(!hm.containsKey(a[i])) hm.put(a[i],1);
                else hm.put(a[i] , hm.get(a[i])+1);
            }
            int count=0;
            for(Map.Entry<Integer,Integer> em : hm.entrySet()){
                if(c<= em.getValue()) count += c;
                else count += em.getValue();
            }
            System.out.println(count);
        }
    }
}
