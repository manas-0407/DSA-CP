package codeforce;

import java.util.*;
import java.io.*;

public class Games {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),i,c=0,x=0;
        Integer j;
        ArrayList<Integer> al1=new ArrayList<>(n);
        ArrayList<Integer> al2=new ArrayList<>(n);
        for(i=0;i<n;i++)
        {
            al1.add(sc.nextInt());
            al2.add(sc.nextInt());
        }
        for (i=0;i<al1.size();i=0)
        {
            j=Integer.valueOf(al1.get(i));
            while(al2.contains(j))
            {
                c++;
                al2.set(al2.indexOf(j),-1);
                x++;

            }
            while(al1.contains(j))
            {
                c=x+c;
                al1.remove(j);
            }
            c-=x;
            x=0;
        }
        System.out.println(c);
    }
}
