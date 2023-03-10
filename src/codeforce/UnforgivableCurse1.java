package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class UnforgivableCurse1 {
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
        manas: while (t-- > 0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            String s1=sc.nextString();
            String s2=sc.nextString();
            int[] a1=new int[26];
            int[] a2=new int[26];
            Arrays.fill(a1,0);
            Arrays.fill(a2,0);
            int i;
            for(i=0;i<n;i++) a1[s1.charAt(i)-'a']++;
            for(i=0;i<n;i++) a2[s2.charAt(i)-'a']++;
            for(i=0;i<26;i++){
                if(a1[i] != a2[i]){
                    out.println("NO");
                    out.flush();
                    continue manas;
                }
            }
            if(n >= 2*k){
                out.println("YES");
                out.flush();
            }else {
                int[] v=new int[26];
                // a b c d e
                i=0;
                while (i+k<n){
                    v[s1.charAt(i)-'a']++;
                    i++;
                }
                i=0;
                while (i+k<n){
                    v[s2.charAt(i)-'a']--;
                    i++;
                }
                i=0;
                while (i+k<n){
                    v[s1.charAt(n-1-i)-'a']++;
                    i++;
                }
                i=0;
                while (i+k<n){
                    v[s2.charAt(n-1-i)-'a']--;
                    i++;
                }
                int x1=i;
                for(i=0;i<26;i++){
                    if(v[i] != 0){                //a b c d e
                        out.println("NO");
                        out.flush();
                        continue manas;
                    }
                }
                i=x1;
                while (i<n && i<k){
                    if(s1.charAt(i) != s2.charAt(i)){
                        out.println("NO");
                        out.flush();
                        continue manas;
                    }
                    i++;
                }
                out.println("YES");
                out.flush();
            }
        }
    }
}

/*
6 3
slmmhg
lmmshg
*/