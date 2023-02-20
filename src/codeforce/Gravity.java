package codeforce;
import java.util.*;
public class Gravity{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,n=sc.nextInt();
        ArrayList<Integer> al=new ArrayList<>(n);
        for(i=0;i<n;i++)
        {
            al.add(sc.nextInt());
        }
        Collections.sort(al);
        for (int a:al)
            System.out.print(a+" ");

        }
    }

