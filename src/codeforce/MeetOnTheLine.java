package Codeforce;

import javax.swing.*;
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class MeetOnTheLine {
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
    private static class Pair {
            int dist;
            int time;

            public Pair(int key, int val) {
                this.dist = key;
                this.time = val;
            }
    }
    static double maxOfAll(Pair[] a,double x){ //key-> pos on line
        // val -> time to dress_up
        double max=Integer.MIN_VALUE;
        double ct;
        for (Pair pair : a) {
            ct = Math.abs(pair.dist - x) + pair.time;
            max = Math.max(max, ct);
        }
        return max;
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0){
            int n=sc.nextInt();
            Pair[] a=new Pair[n]; // Dec then Inc function.
            int i;
            int maxD=Integer.MIN_VALUE;
            for(i=0;i<n;i++){
                int vm=sc.nextInt();
                a[i] = new Pair(vm,0);
                maxD = maxD > vm ? maxD : vm;
            }
            for(i=0;i<n;i++){
                a[i].time = sc.nextInt();
            }
//            for(double vv=0;vv<maxD;vv+=0.5){
//                out.println(maxOfAll(a,vv));
//            }

            double l=0,r=maxD;
            while (r-l > 1e-8){
                double m1 = l + (r-l)/3;
                double m2 = r - (r-l)/3; // m1 first and m2 second
                double vv1 = maxOfAll(a,m1);
                double vv2 = maxOfAll(a,m2);
                if(vv1 < vv2){
                    // m1 =left and m2= right or m1 =right =m2
                    r=m2;
                }
                else if(vv1 > vv2){
                    l=m1;
                }
                else {
                    l=m1;
                    r=m2;
                }
            }
            out.println(String.format("%.9f",l));
            out.flush();
        }
    }
}
