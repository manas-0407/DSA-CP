package codeforce;
import java.util.*;
public class GeorgeAndAcoomodate {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt(),c=0,i,j;
        int[][] a=new int[n][2];
        for(i=0;i<n;i++)
        {
            for(j=0;j<=1;j++) {
                a[i][j] = sc.nextInt();
                if(j==1 && a[i][0]<a[i][1]-1)
                    c++;
            }
        }
        System.out.println(c);
    }
}
