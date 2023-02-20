package codeforce;
import java.util.*;
public class Football {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j;
        String s=sc.next();
        String st;
        if(s.length()<7)
            System.out.println("NO");
        else {
            for (i = 0; i <= s.length() - 7; i++) {
                st = s.substring(i, 7+i);
//            System.out.println(s.length());
//                System.out.println(st+st.length());
                for (j=1;j<7;j++)
                {
                    if(st.charAt(j)!=st.charAt(j-1))
                        break;
                }
                if(j==7)
                {
                    System.out.println("YES");
                    break;
                }
            }
            if(i==s.length()-6)
                System.out.println("NO");
        }
    }
}
