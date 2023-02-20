package codeforce;
import java.util.Scanner;
public class Team {
    public static void main(String[] args) {
        int n,i,count,t=0;
        int[] a= new int[3];
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        while(n--!=0)
        {
            count=0;
            for(i=0;i<3;i++)
            {
                a[i] = sc.nextInt();
                if(a[i]==1)
                    count++;
            }
            if(count>1)
                t++;
        }

        System.out.println(t);
    }
}
