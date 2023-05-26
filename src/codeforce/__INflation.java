package Codeforce;

import java.util.*;
import java.io.*;

public class __INflation {
    static FastRead sc = new FastRead(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    private static class FastRead {
        private final InputStream stream;
        private final byte[] buf = new byte[1<<18];
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
    static boolean checker(int[] a,double dd, long x){
        long sum=a[0]+x;
        for(int i=1;i<a.length;i++){
            double xx=(a[i]*1.0) / sum;
//            debug(xx+" "+dd);
            if(xx > dd) return false;
            sum+=a[i];
        }
        return true;
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            double dd=k/100.0;
            int i;
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}
//            long sum,val=0;
//            for(i=1;i<n;i++){
//                double x=(a[i]*1.0) / sum;
//                if(x>dd){
//                    long vv= (long) Math.ceil(a[i]*1.0 / dd);
//                    val += (vv-sum);
//                    sum=vv;
//                }
//                sum+=a[i];
//            }
//            boolean b=true;
//            while (b&&val>=0){
//                val--;
//                sum=a[0]+val;
//                for(i=1;i<n&& b;i++){
//                    double x=(a[i]*1.0) / sum;
//                    if(x>dd) b=false;
//                    sum+=a[i];
//                }
//            }
//            out.println(val+1);
            long l=0,r= (long) 1e17;
            int ct=200;
            while (l<=r && ct-->0){
                long mid=l+(r-l)/2;
                boolean mv=checker(a,dd,mid);
                if(mv){
                    r=mid;
                }
                else l=mid;
                if(l==r) break;
            }
            out.println(r);
            out.flush();
        }
    }
}


/*
1
5 32
1 1 2 4 2
 */