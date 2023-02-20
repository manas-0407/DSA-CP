package codeforce;
import java.util.*;
public class Elephant {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

        int p=sc.nextInt();
        if(p%5!=0)
        System.out.println((p-p%5)/5 +1);
        else
            System.out.println(p/5);
    }
}
