package codeforce;
import java.util.*;
public class BeatyYear {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int y=sc.nextInt();
        int i,j,k=0;
        String s;
        for(i=y+1;i>0;i++)
        {
            s=Integer.toString(i);

            for(j=0;j<3;j++)
            {
                for(k=j+1;k<4;k++)
                {
                    if(s.charAt(k)==s.charAt(j))
                    {
                        break;
                    }
                }
                if(k!=4)
                    break;
            }
            if(j==3)
            {
                System.out.println(s);
                break;
            }
        }
    }
}
