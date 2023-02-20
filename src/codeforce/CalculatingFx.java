package codeforce;
import java.util.*;
public class CalculatingFx {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long ne,no;
        ne=n/2;
        no=(n+1)/2;
        System.out.println(ne*ne + ne - no*no);
    }
}
