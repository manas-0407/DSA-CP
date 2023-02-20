package codeforce;

import java.util.*;

public class GivenLenDigiSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), s = sc.nextInt();
        if (s > m * 9 || (s == 0 && m>1))
            System.out.println(-1 + " " + -1);

        else {
            StringBuilder st=new StringBuilder();
            int t,c=1,s1=s,m1=m;


            while(m-- > 0)
            {
                if(s>m*9 || s==0)
                {
                    if(m==0)
                        t=s%9;
                    else
                        t=s%(m*9);

                    if(t==0 && s!=0)
                        t=9;
                }
                else
                {
                    t=c;
                    if(c==1)
                        c=0;
                }

                st.append(t);
                s=s-t;
            }
            System.out.print(st+ " ");

            s=s1;
            m=m1;
            st=new StringBuilder();
            while(m-- > 0)
            {
                if(s/9 > 0)
                    t=9;
                else
                    t=s%9;
                st.append(t);
                s=s-t;
            }
            System.out.print(st);
        }
    }
}
