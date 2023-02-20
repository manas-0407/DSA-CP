package codeforce;
import java.util.*;

public class QueueSchool {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,n=sc.nextInt(),t=sc.nextInt();
        String st=sc.next();
        char[] s=new char[n];
        for(i=0;i<n;i++)
            s[i]=st.charAt(i);
        for(i=0;i<t;i++)
        {
            for(j=0;j<n-1;j++)
            {
                if(s[j]=='B' && s[j+1]=='G')
                {
                    s[j]='G';
                    s[j+1]='B';
                    j++;
                }
            }
        }
        for(char c:s)
        System.out.print(c);
    }
}
