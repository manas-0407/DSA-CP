package codeforce;

public class HackingOth {
    public static void main(String[] args) {
        int t=(int) (5*1e3-1);
        System.out.println(t);
        while (t-->0){
        int x= (int) (2*1e5-1);
        System.out.println(x);
        for(int i=1;i<=x;i++) {
            if(i!=x)
            System.out.print(2*i+" ");
            else System.out.println(2*i);
        }
    }}
}
