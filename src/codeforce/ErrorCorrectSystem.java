package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class ErrorCorrectSystem {
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
        int n=sc.nextInt();
        String s=sc.nextString();
        String t=sc.nextString();
        StringBuilder s1=new StringBuilder(),s2=new StringBuilder();
        int i;
        for(i=0;i<n;i++){
            if(s.charAt(i) != t.charAt(i)){
                s1.append(s.charAt(i));
                s2.append(t.charAt(i));
            }
        }
        // lets associate s2 string corresponding with s1 -> s2 char key
        HashMap<Character,HashSet<Character>> hm = new HashMap<>();
        for(i=0;i<s1.length();i++){
            if(!hm.containsKey(s1.charAt(i)))
                hm.put(s1.charAt(i),new HashSet<>());
            hm.get(s1.charAt(i)).add(s2.charAt(i));
        }
        int minV = -1;
        char c1='a',c2='b';
        for(i=0;i<s1.length();i++){
            if(hm.containsKey(s2.charAt(i))){
                minV=1;
                c1=s1.charAt(i);
                c2=s2.charAt(i);
                if(hm.get(s2.charAt(i)).contains(s1.charAt(i))){
                    minV=2;
                    c1=s1.charAt(i);
                    c2=s2.charAt(i);
                    break;
                }
            }
        }
        if(minV == -1){
            out.println(s1.length());
            out.println("-1 -1");
        }else {
            int pos1=0,pos2=0;
            for(i=0;i<n;i++){
                if(s.charAt(i) == c2) pos1=i+1;
                if(s.charAt(i) == c1) pos2=i+1;
            }
            out.println(s1.length() - minV);
            out.println(pos1+" "+pos2);
        }
        out.flush();
    }
}
