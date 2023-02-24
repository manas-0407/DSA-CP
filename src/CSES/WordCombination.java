package CSES;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class WordCombination {
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
    static class Tries{
        Tries[] t=new Tries[26]; //each position for each alpha
        boolean isLastAlpha = false;
    }

    private static class Pair {
            boolean key;
            int val;

            public Pair(boolean key, int val) {
                this.key = key;
                this.val = val;
            }
    }
    static Pair triesSearch(String s,Tries root){
        for(int i=0;i<s.length();i++){
            if(root.t[s.charAt(i)-97] == null) return new Pair(false,1); // code 1 means character chain missing
            root = root.t[s.charAt(i)-97];
        }
        return new Pair(root.isLastAlpha,0); // code 0 means chain is present but not end of word
    }

    public static void main(String[] args)throws IOException {
        String vv=sc.nextString();
        Tries root = new Tries();
        int t=sc.nextInt();
        while (t-- > 0){
            String s=sc.nextString();
            Tries ptr = root;
            for(int i=0;i<s.length();i++){
                int vm=s.charAt(i)-97;
                if(ptr.t[vm] == null) ptr.t[vm] =new Tries();
                ptr = ptr.t[vm];
            }
            ptr.isLastAlpha = true;
        }
        long[] dp=new long[vv.length()+1];
        Arrays.fill(dp,0);
        dp[vv.length()] = 1;
        for(int i=vv.length() -1; i>-1;i--){

            for(int j= i;j<vv.length();j++){
                String s=vv.substring(i,j+1);
                Pair ppx=triesSearch(s,root);
                if(ppx.key) {
                    dp[i]+=dp[j+1];
                    if(dp[i] > mod) dp[i] %= mod;
                }
                else if(ppx.val == 1) break;
            }
        }
        out.println(dp[0]);
        out.flush();
    }
}
