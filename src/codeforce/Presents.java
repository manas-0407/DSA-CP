package codeforce;

import java.util.*;

public class Presents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> x=new ArrayList<>(n);
        int i;
        for(i=0;i<n;i++)
            x.add(sc.nextInt());
        for(i=0;i<n;i++)
            System.out.print((x.indexOf(i+1)+1)+" ");
    }
}
