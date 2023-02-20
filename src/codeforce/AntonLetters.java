package codeforce;
import java.util.*;
public class AntonLetters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        ArrayList<Character> ch=new ArrayList<>(10);
        int i,c=0;
        char z;
        for(i=1;i<s.length()-1;i=i+3)
            ch.add(s.charAt(i));
        for(i=0;i<ch.size();i++)
        {
            z=ch.get(i);
            if(ch.lastIndexOf(z)==ch.indexOf(z) || i==ch.indexOf(z))
            c++;
        }
        System.out.println(c);
    }
}
