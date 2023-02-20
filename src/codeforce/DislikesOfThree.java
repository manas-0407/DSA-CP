package codeforce;

import java.util.*;

public class DislikesOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int i=1;
        ArrayList<Integer> al=new ArrayList<>(10);
        while(al.size()!=1000)
        {
            if(i%3!=0 && i % 10 !=3)
                al.add(i);
            i++;
        }
        while(t-- > 0)
        {
            int k=sc.nextInt();
            System.out.println(al.get(k-1));
        }
    }
}
