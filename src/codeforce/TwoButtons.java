package codeforce;

import java.util.*;

public class TwoButtons {

    static int count=0;
    static void recButton(int x,int target){
        System.out.println(x+",  "+target);
        count++;
        if(x==target) return;
        else if((2*x<target && target<=3*x) || (target<=1.5*x)) recButton(--x,target);
        else if(3*x<target || target<=2*x) recButton(2*x,target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int target=sc.nextInt();
        recButton(x,target);
        System.out.println(--count);
    }
}
