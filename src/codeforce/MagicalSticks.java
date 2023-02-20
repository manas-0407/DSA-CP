package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicalSticks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n=Integer.parseInt(br.readLine());
            if(n%2 == 1)
                System.out.println(n/2+1);
            else
                System.out.println(n/2 );
        }
    }
}
