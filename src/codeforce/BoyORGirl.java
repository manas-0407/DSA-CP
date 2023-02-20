package codeforce;
import java.util.Scanner;
public class BoyORGirl {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] character=new int[26];
        String s=sc.next();
        for(int i=0;i<s.length();i++)
        {
            character[s.charAt(i)-97]++;
        }
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(character[i]>0)
                count++;
        }
        if(count%2==0)
            System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
    }
}