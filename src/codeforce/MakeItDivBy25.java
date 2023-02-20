package codeforce;

import java.util.*;

public class MakeItDivBy25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            StringBuilder s=new StringBuilder(sc.next());
            int i,ini0=-1,ini5=-1,end0=Integer.MAX_VALUE,end2=Integer.MAX_VALUE,end5=Integer.MAX_VALUE,end7=Integer.MAX_VALUE;
            for(i=s.length()-1;i>-1;i--)
            {
                if(s.charAt(i)=='0') {
                    if(ini0==-1)
                    ini0 = i;
                    else if(end0==Integer.MAX_VALUE) {
                        end0 = i;
                    }
                }
                else if(s.charAt(i)=='5')
                {
                    if(ini5==-1)
                        ini5=i;
                    else if(end5==Integer.MAX_VALUE) {
                        end5 = i;
                    }
                }
                else if(s.charAt(i)=='2' && end2==Integer.MAX_VALUE && ini5!=-1)
                    end2=i;
                else if(s.charAt(i)=='7' && end7==Integer.MAX_VALUE && ini5!=-1)
                    end7=i;
            }
            int l=s.length()-1;
            int[] ar=new int[5];

//            System.out.println(ini0+ " "+ini5+ " " +end0+" "+end2+" "+end5+" "+end7);

//            ar[0]=Math.abs(-end2+end5-1) + Math.abs(l-end5);
//            ar[1]=-end2+ini5-1 + l-ini5;
//
//            ar[2]=Math.abs(-end7+end5-1) + Math.abs(l-end5);
//            ar[3]=-end7+ini5-1 + l-ini5;
//
//            ar[4]=Math.abs(-end5+end0-1) + Math.abs(l-end0);
//            ar[5]=-end5+ini0-1 + l-ini0;
//            ar[6]=Math.abs(-ini5+end0-1) + Math.abs(l-end0);
//            ar[7]=-ini5+ini0-1 + l-ini0;
//
//            ar[8]=-end0+ini0-1 + l-ini0;

//            System.out.println(Arrays.toString(ar));
            if(ini5!=-1 && ini0!=-1)
            {
                ar[0]=Math.abs(-end5+end0-1) + Math.abs(l-end0);
                ar[1]=-end5+ini0-1 + l-ini0;
                ar[2]=Math.abs(-ini5+end0-1) + Math.abs(l-end0);
                ar[3]=-ini5+ini0-1 + l-ini0;
                ar[4]=-end0+ini0-1 + l-ini0;
                int min=Integer.MAX_VALUE;
                for(i=0;i<5;i++)
                {
                    if(ar[i]<min && ar[i]>=0)
                        min=ar[i];
                }
//                System.out.println(Arrays.toString(ar));
                System.out.println(min);
            }
            else if(ini0 == -1)
            {
                ar[0]=Math.abs(-end2+end5-1) + Math.abs(l-end5);
            ar[1]=-end2+ini5-1 + l-ini5;

            ar[2]=Math.abs(-end7+end5-1) + Math.abs(l-end5);
            ar[3]=-end7+ini5-1 + l-ini5;
            int min=Integer.MAX_VALUE;
                for(i=0;i<4;i++)
                {
                    if(ar[i]<min && ar[i]>=0)
                        min=ar[i];
                }
                System.out.println(min);
            }
            else
            {
                System.out.println(-end0+ini0-1 + l-ini0);
            }

//            int min=Integer.MAX_VALUE;
//            for(i=0;i<9;i++)
//            {
//                if(ar[i]<min && ar[i]>=0)
//                    min=ar[i];
//            }
//            System.out.println(min);
        }
    }
}
