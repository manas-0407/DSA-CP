package Recursion_Problems;

import java.util.*;
import java.io.*;
// Recursive of CSES Array Description Problem.
public class ArrayDescPr {
    static FastRead sc = new FastRead(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    private static class FastRead {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar, numChars;
        public FastRead (InputStream stream) {
            this.stream = stream;
        }
        public FastRead (String file) throws IOException {
            this.stream = new FileInputStream (file);
        }
        void run() {
            try {
                PrintStream fs = new PrintStream("error.txt");
                System.setErr(fs);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        public int cscan () throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read (buf);
            }
            if (numChars == -1)
                return numChars;
            return buf[curChar++];
        }
        public int nextInt () throws IOException {
            int c = cscan (), sgn = 1;
            while (space (c))
                c = cscan ();
            if (c == '-') {
                sgn = -1;
                c = cscan ();
            }
            int res = 0;
            do {
                res = (res << 1) + (res << 3);
                res += c - '0';
                c = cscan ();
            }
            while (!space (c));
            return res * sgn;
        }
        public String nextString () throws IOException {
            int c = cscan ();
            while (space (c))
                c = cscan ();
            StringBuilder res = new StringBuilder ();
            do {
                res.appendCodePoint (c);
                c = cscan ();
            }
            while (!space (c));
            return res.toString ();
        }
        public double nextDouble () throws IOException {
            int c = cscan (), sgn = 1;
            while (space (c))
                c = cscan ();
            if (c == '-') {
                sgn = -1;
                c = cscan ();
            }
            double res = 0;
            while (!space (c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * exp(10, nextInt ());
                res *= 10;
                res += c - '0';
                c = cscan ();
            }
            if (c == '.') {
                c = cscan ();
                double m = 1;
                while (!space (c)) {
                    if (c == 'e' || c == 'E')
                        return res * exp(10, nextInt ());
                    m /= 10;
                    res += (c - '0') * m;
                    c = cscan ();
                }
            }
            return res * sgn;
        }
        public long nextLong () throws IOException {
            int c = cscan (), sgn = 1;
            while (space (c))
                c = cscan ();
            if (c == '-') {
                sgn = -1;
                c = cscan ();
            }
            long res = 0;
            do {
                res = (res << 1) + (res << 3);
                res += c - '0';
                c = cscan ();
            }
            while (!space (c));
            return res * sgn;
        }
        public boolean space (int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
    static final int mod = 1_000_000_007;
    static long mul(long a, long b) {
        return (a * b) % mod;
    }
    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static void debug(Object... o){
        if(o.length != 0) System.err.println(Arrays.deepToString(o));
        else System.err.println();
    }
    static long findPath(int x,int y,int m,int gap){

        if(gap<0) return 0;
        if(gap==0){
            if(Math.abs(x-y)<=1) return 1;
            else return 0;
        }
        return (x+1<=m?findPath(x+1,y,m,gap-1):0) + (x<=m?findPath(x,y,m,gap-1):0) + (x-1>=1?findPath(x-1,y,m,gap-1):0);
    }
    public static void main(String[] args)throws IOException {
        int n=sc.nextInt();
        int m=sc.nextInt();
        int i;
        int[] a=new int[n];
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int now,gap;
        long getPerm=1;
        i=0;
        int j=n-1;
        if(a[0]==0){
            gap=-1;
            while(i<n-1 && a[i] == 0){
                gap++;
                i++;
            }
            long sum=0;
            for(now=1;now<=m;now++)
                sum+= findPath(now,a[i],m,gap);
            getPerm*=sum;
        }
        if(a[j]==0){
            gap=-1;
            while(j>=0 && a[j] == 0){
                gap++;
                j--;
            }
            long sum=0;
            for(now=1;now<=m;now++)
                sum += findPath(now,a[j],m,gap);
            getPerm*=sum;
        }
        now=a[i];
        for(;i<=j;i++){
            gap=0;
            while(i<=j && a[i] == 0){
                gap++;
                i++;
            }
            getPerm *= findPath(now,a[i],m,gap);
            now=a[i];
        }
        out.println(getPerm);
        out.close();
    }
}
