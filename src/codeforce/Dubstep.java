package codeforce;
import java.util.*;
public class Dubstep {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String[] starr=s.split("WUB");
        ArrayList<String> strList = new ArrayList<>(
                Arrays.asList(starr));
        for (String value : strList) {
            if (value.compareTo("") != 0) {
                System.out.print(value + " ");
            }
        }
    }
}
