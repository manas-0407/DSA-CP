package codeforce;
import java.util.*;
public class HelpfulMaths {
    public static void main(String[] args) {
        int t=0;
        Scanner sc=new Scanner(System.in);
        String s= sc.next();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<s.length();j=j+2)
            {
                    if(s.charAt(j)==(49+i)) {
                        t++;
                        if(t!=(s.length()+1)/2)
                        System.out.print(s.charAt(j) + "+");
                        else
                            System.out.println(s.charAt(j));

                    }
            }
        }
    }
}
