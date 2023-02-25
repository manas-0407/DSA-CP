package Tree;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Tries {
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

    static class TriesNode{
        TriesNode[] tn=new TriesNode[26];
        boolean isLastAlpha;
        TriesNode(){
            Arrays.fill(tn,null);
            isLastAlpha=false;
        }
    }

    static boolean trieSearch(TriesNode root,String s){
        TriesNode ptr=root;
        for(int i=0;i<s.length();i++){
            char v=s.charAt(i);
            if(ptr.tn[v-97] == null) return false;
            ptr = ptr.tn[v-97];
        }
        return ptr.isLastAlpha;
    }

    public static void main(String[] args)throws IOException {
        TriesNode rootNode = new TriesNode();
        int Words=sc.nextInt();
        while (Words-- > 0){
            String s=sc.nextString();
            s=s.toLowerCase();
            TriesNode ptr=rootNode;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(ptr.tn[c-97] == null)
                    ptr.tn[c-97] = new TriesNode();
                ptr = ptr.tn[c-97];
                if(i==s.length()-1) ptr.isLastAlpha = true;
            }
        }
        out.println("Search");
        out.flush();
        int ss=sc.nextInt();
        while (ss-- > 0){
            String vi=sc.nextString();
            out.println(trieSearch(rootNode,vi)?"YES":"NO");
            out.flush();
        }
    }
}
