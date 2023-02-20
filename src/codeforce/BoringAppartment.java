package codeforce;

import java.util.*;

public class BoringAppartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int x=sc.nextInt();
            int i=1,co=(x%10 - 1)*10;
            while(x != 0)
            {
                co=co+i;
                i++;
                x/=10;
            }
            System.out.println(co);
        }
    }
}
