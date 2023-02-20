package codeforce;
import java.util.*;
public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,n=sc.nextInt();
        int[][] a=new int[n][3];
        for(i=0;i<n;i++)
        {
            for(j=0;j<3;j++)
                a[i][j]=sc.nextInt();
        }

        int c=0,sum=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<n;j++)
            {
                sum=sum+a[j][i];
            }
            if(sum==0)
                c++;
            sum=0;
        }
        if(c==3)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
