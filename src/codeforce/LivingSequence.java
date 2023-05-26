package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class LivingSequence {

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
    static long getPos(long v){
        long h=1;
        while (v!=0){
            if(v%10 == 4) return -1;
            if(v < 10){
                if(v<4) h*=(v+1);
                else h*=v;
                v/=10;
            }else {
                h*=9;
                v/=10;
            }
        }
        return h-1;
    }
    static long under4ct(long x){
        debug("h");
        if(x<10){
            if(x<4) return 0;
            else return 1;
        }
        long vv=x;
        int ct=0;
        while (vv>=10){
            ct++;
            vv/=10;
        }
        debug("Fucl");
        vv= (long) (vv*Math.pow(10,ct) - 1);
        long m=1,mv=vv;
        while (mv!=0){
            if(mv<10){
                mv*=(mv<4?mv+1:mv);
                mv/=10;
            }else {
                m*=9;
                mv/=10;
            }
        }
        debug("F2");
        mv--;
        return (vv-mv)+under4ct(x-vv);
    }
    public static void main(String[] args)throws IOException {

        // Find pos of a random number say X
        // if pos(X) in Living seq < K, ans>X
        //else if pos(X) > k, ans<X
        // else ans = X
        int t=sc.nextInt();
        manas: while(t-- >0){
//            debug(getPos(19));
//            debug(getPos(99));
            long k=sc.nextLong();
            long l=1,r= (long) (1e12+2); // l < ans and r>ans
            while (l<r){
                debug(l+" "+r);
                long mid=l+(r-l)/2;
//                long pos=getPos(mid);
//                while (pos == -1 ){
//                    long xx=mid;
//                    mid=xx+(r-xx)/2;
//                    pos=getPos(mid);
//                }
                long pos=mid-under4ct(mid);
                debug(pos);
                if(pos < k) l=mid;
                else if(pos > k) r=mid;
                else {
                    out.println(mid);
                    out.flush();
                    continue manas;
                }
                if(r-l==1) break ;
            }
            out.println(r);
            out.flush();
        }
    }
}
