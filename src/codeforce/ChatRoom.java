package codeforce;
import java.util.*;
public class ChatRoom {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] ch={'h','e','l','l','o'};
        String s=sc.next();
        int i,j=0;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)==ch[j])
            {
                j++;
                if(j==5)
                    break;
            }
        }
        if(j==5)
        System.out.println("YES");
        else
            System.out.println("NO");
    }
}
