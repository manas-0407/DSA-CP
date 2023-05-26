package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class ChallengingCliffs {
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

    static void ruffleSort(int[] a) {
            int n = a.length;  //shuffle then sort to decrease worst case probability
            for (int i = 0; i < n; i++) {
                int oi = random.nextInt(n), temp = a[oi];
                a[oi] = a[i];
                a[i] = temp;
            }
            Arrays.sort(a);
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t--  >0){
            int n=sc.nextInt();
//            int h=sc.nextInt();
            int[] a=new int[n];
            int i;
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}
            ruffleSort(a);
            int min=Integer.MAX_VALUE,am=-1,bm=-1;
            for(i=0;i<n-1;i++){
                if(Math.abs(a[i]-a[i+1]) < min) {
                    min=Math.abs(a[i]-a[i+1]);
                    am=a[i];
                    bm=a[i+1];
                }
            }
            int v1=am,v2=bm;
            for(i=n-1;i>-1;i--){
                if(a[i] == v1){
                    a[i]=Integer.MAX_VALUE;
                    v1=-1;
                }else if(a[i] == v2) {
                    a[i] = Integer.MAX_VALUE ;
                    v2=-1;
                }
            }
            debug(a);
            int here=-1;
            out.print(am +" ");
            for(i=0;i<n;i++){
                if(a[i] > am && a[i] != Integer.MAX_VALUE){
                    if(here == -1) here= i;
                    out.print(a[i]+" ");
                }
            }
            i=0;
            here = here==-1?n-2:here;
            while (i<here) {
                out.print(a[i]!=Integer.MAX_VALUE?a[i]+" ":"");
                i++;
            }
            out.println(bm);
            out.flush();
        }
    }
}
