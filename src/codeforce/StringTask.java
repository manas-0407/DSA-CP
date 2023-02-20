package codeforce;
import java.util.*;
public class StringTask {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        char x;
        String s=sc.next();
        for(int i=0;i<s.length();i++)
        {
            x=s.charAt(i);
            if(x=='A'||x=='E'||x=='I'||x=='O'||x=='U'||x=='Y'||x=='a'||x=='e'||x=='i'||x=='o'||x=='u'||x=='y')
            {
                continue;
            }
            else {
                if (x >= 65 && x < 91) {
                    System.out.print("."+((char)(32 + x)));
                }
                else
                    System.out.print("."+x);
            }
        }
    }
}
