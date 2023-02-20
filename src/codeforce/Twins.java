package codeforce;
import java.util.*;
public class Twins {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,temp,n=sc.nextInt(),sum=0,sum2=0;
        int[] a=new int[n];
        for(i=0;i<n;i++) {
            a[i] = sc.nextInt();
            sum = sum + a[i];
        }
        for (i=0;i<n-1;i++)
        {
            for (j=0;j<n-i-1;j++)
            {
                if (a[j] < a[j+1])
                {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        // System.out.println(Arrays.toString(a));
        for(i=0;i<n;i++)
        {
            sum2=sum2+a[i];
            if(2*sum2>sum)
            {
                break;
            }
        }
        System.out.println(i+1);
    }
}
