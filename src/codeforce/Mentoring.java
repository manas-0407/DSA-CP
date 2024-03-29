package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Mentoring {
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
            int key;
            int val;

            public Pair(int key, int val) {
                this.key = key;
                this.val = val;
            }
    }
    public static void main(String[] args)throws IOException {
        int n=sc.nextInt();
        int k=sc.nextInt();
        Pair[] a=new Pair[n];
        int i;
        for(i=0;i<n;i++) {a[i]=new Pair(sc.nextInt(),i);}
        HashMap<Integer,Integer> hm=new HashMap<>();
        while (k-- > 0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            --l;
            --r;
            if(a[l].key < a[r].key){
                hm.put(r,hm.getOrDefault(r,0)+1);
            }else if(a[l].key > a[r].key) hm.put(l,hm.getOrDefault(l,0)+1);
        }
        Arrays.sort(a,(x,y)->{return x.key-y.key;});
        int[] ans=new int[n];
        int ct=0,temp=0;
        for(i=0;i<n;i++){
            ans[a[i].val] = ct-hm.getOrDefault(a[i].val,0) < 0 ? 0 : ct-hm.getOrDefault(a[i].val,0);
            if(i+1<n){
                 if(a[i].key < a[i+1].key){
                     ct=ct+temp+1;
                     temp=0;
                 }else temp++;
            }
            debug(ct);
        }
        for(int xx:ans) out.print(xx+" ");
        out.flush();
    }
}
