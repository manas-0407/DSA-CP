package codeforce;

import java.util.*;

public class DesignTutorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        if(n%2==0)
            System.out.println(4+" "+(n-4));
        else
            System.out.println(9+" "+(n-9));
    }
}
