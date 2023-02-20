package codeforce;

import java.util.*;

public class TeamOlympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> al=new ArrayList<>(n);
        int i;
        int[] count=new int[3];
        for(i=0;i<n;i++) {
            al.add(sc.nextInt());
            count[al.get(i)-1]++;
        }
        //System.out.println(Arrays.toString(count));
        int min=count[0];
        for(i=1;i<3;i++)
        {
            if(min>count[i])
                min=count[i];
        }
        System.out.println(min);
        for(i=0;i<min;i++)
        {
            System.out.print(al.indexOf(1)+1 +" ");
            al.set(al.indexOf(1),-1);
            System.out.print(al.indexOf(2)+1 +" ");
            al.set(al.indexOf(2),-1);
            System.out.print(al.indexOf(3)+1 +" ");
            al.set(al.indexOf(3),-1);
            System.out.println();
        }
    }
}
