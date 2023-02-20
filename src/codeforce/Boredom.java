package codeforce;

import java.util.*;

public class Boredom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> al=new ArrayList<>(n);
        int i,point=0;
        for(i=0;i<n;i++)
        {
            al.add(sc.nextInt());
        }
        Integer I=Collections.max(al);
        int c;
        while(I != -1)
        {
            System.out.println("Entered with max "+I);
            I=I -1;
            if(al.contains(I))
            {
                System.out.println("Entered if with I "+I);
                point=point+I;
                c=0;
                for(i=0;i<n;i++)
                {
                    if(al.get(i)==I+1 || al.get(i)==I-1)
                        al.set(i,-1);
                    if(al.get(i).equals(I) && c==0)
                    {
                        c=1;
                        al.set(i,-1);
                    }
                }
            }
            else if(al.contains(I+1))
            {
                System.out.println("Entered else if");
                for(i=0;i<n;i++)
                {
                    if(al.get(i).equals(I+1)) {
                        point=point+I+1;
                        al.set(i, -1);
                    }
                }
            }
            else
            {
                System.out.println("Entered else");
                for(i=0;i<n;i++)
                {
                    if(al.get(i).equals(I))
                        al.set(i,-1);
                }
            }
            I=Collections.max(al);
//            for(int j: al)
//                System.out.print(j+" ");
//            System.out.println();
//            System.out.println();
        }
        System.out.println(point);
    }
}
