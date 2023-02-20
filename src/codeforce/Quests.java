package codeforce;

import java.util.*;
import java.io.*;

public class Quests {
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
    static final Random random = new Random();

    static void ruffleSort(long[] a) {
            int n = a.length;  //shuffle then sort to decrease worst case probability
            for (int i = 0; i < n; i++) {
                int oi = random.nextInt(n);long temp = a[oi];
                a[oi] = a[i];
                a[i] = temp;
            }
            Arrays.sort(a);
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            long c=sc.nextLong(); //target coins
            int d=sc.nextInt(); // under days
            long[] a=new long[n];
            int i;
            for(i=0;i<n;i++) a[i]=sc.nextInt();
            ruffleSort(a);
            long[] suffsum=new long[n];
            for(i=n;i>0;i--){
                suffsum[n-i]= i==n ? a[n-1] : a[i-1]+suffsum[n-i-1];
            }
            int mn=Math.min(n-1,d-1);
            if(suffsum[mn] >= c) {
                out.println("Infinity");
                out.flush();
                continue;
            }
            if(a[n-1]*d < c){
                out.println("Impossible");
                out.flush();
                continue;
            }
//            debug(suffsum);
            int l=0,r=d-1,ans=0;
            long val;
            while (l<=r){
                int k=l+(r-l)/2;
                if(k<n) val = d/(k+1) * suffsum[k] + ((d%(k+1) != 0)? suffsum[d%(k+1)-1] : 0);
                else {
                    val = suffsum[n-1]*(d/(k+1)) +
                            ((d%(k+1) != 0)? suffsum[Math.min(d%(k+1)-1  , n-1)] : 0);
                }
//                debug("k: "+k+" val: "+val);
                if(val >= c){
                    ans=k;
                    l=k+1;
                }
                else r=k-1;
            }
            out.println(ans);
            out.flush();
        }
    }
}
/*

1
5 30 10
1 2 3 4 5

 */