package codeforce;
import java.util.*;
public class ArrivalOfGeneral {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),sum=0;
        ArrayList<Integer> al=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        sum=sum+n-1-al.lastIndexOf(Collections.min(al));
        //System.out.println(al.lastIndexOf(Collections.max(al)));
        sum=sum+al.indexOf(Collections.max(al));
        if(al.indexOf(Collections.max(al)) > al.lastIndexOf(Collections.min(al)))
        sum=sum-1;


        System.out.print(sum);
    }
}
