package codeforce;
import java.util.*;
public class Tram
{
    public static void main(String[] args)
    {

            int n,i,j,t,y;
            Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            int[][] a=new int[n][2];
            for(i=0;i<n;i++)
            {
                for(j=0;j<2;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }

            if(n>2) {
                y = a[0][1];
                t=y;

                for (i = 0; i < n - 1; i++) {
                    y = y - a[i + 1][0] + a[i + 1][1];

                    // c=c+a[i+1][1];
                    if (y > t)
                        t = y;
                }
                System.out.println(t);
            }
                else
                System.out.println(a[0][1]);
            }


}
