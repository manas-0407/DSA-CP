package codeforce;

import java.io.*;
import java.util.Arrays;

public class CakeAssemblyLine {
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
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt(); // cake inc
            int h = sc.nextInt(); // dispenser inc
            int[] a = new int[n]; //cake
            int[] b = new int[n]; // dispenser
            int i;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();
            for (i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
//            for(i=1;i<n;i++){
//                int cakecdnt=a[i]-a[0];
//                int discdnt=b[i]-b[0];
//                debug(cakecdnt);
//                debug(discdnt);
//                if(!(cakecdnt-w<=discdnt-h && cakecdnt+w>=discdnt+h)){
//                    out.println("NO");
//                    out.flush();
//                    continue manas;
//                }
//            }

            int l = 0, r = 0;
            for (i = 0; i < n; i++) {
                int cl = a[i] - w;
                int cr = a[i] + w;
                int dl = b[i] - h;
                int dr = b[i] + h;
                if (cl <= dl && cr >= dr) {}
                else if (cr < dr) r++; //shift r
                else l++; // shift l
            }
            if (l > 0 && r > 0) out.println("NO");
            else if (r > 0) {
                // only right
                int maxr = Integer.MAX_VALUE, minr = Integer.MIN_VALUE;
                for (i = 0; i < n; i++) {
                    int cl = a[i] - w;
                    int cr = a[i] + w;
                    int dl = b[i] - h;
                    int dr = b[i] + h;

                    int minstep = dr - cr;
                    int maxstep = dl - cl;
                    minr = Math.max(minr, minstep);
                    maxr = Math.min(maxstep, maxr);
                }
                if (minr > maxr) out.println("NO");
                else out.println("YES");
            } else {
                // only left
                int maxr = Integer.MAX_VALUE, minr = Integer.MIN_VALUE;
                for (i = 0; i < n; i++) {
                    int cl = a[i] - w;
                    int cr = a[i] + w;
                    int dl = b[i] - h;
                    int dr = b[i] + h;

                    int minstep = cl - dl;
                    int maxstep = cr - dr;
                    minr = Math.max(minr, minstep);
                    maxr = Math.min(maxstep, maxr);
                }
                if (minr > maxr) out.println("NO");
                else out.println("YES");
            }
            out.flush();
        }
    }
}
