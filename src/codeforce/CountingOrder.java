package Codeforce;
/*

2nd approach

 */
import java.util.*;
import java.io.*;


public class CountingOrder {
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
    static int closestRight(int x,int[] arr){
        // returns index position
        int mid,i=0,j=arr.length-1,pos=-1;
        while(i<=j){
            mid=i+((j-i)>>1);
            if(arr[mid] >= x){
                pos=mid;
                j=mid-1;
            }
            else i=mid+1;
        }
        return pos;
    }
    static int closestLeft(int x,int[] arr){
        // returns index position
        int mid,i=0,j=arr.length-1,pos=-1;
        while(i<=j){
            mid=i+((j-i)>>1);
            if(arr[mid] <= x){
                pos=mid;
                i=mid+1;
            }
            else j=mid-1;
        }
        return pos;
    }
    static long expMod(long base, long exp, long modulo){ // T.C: O(log exp)
        long res = 1; base = base % modulo;if (base == 0) return 0;while (exp > 0) {if ((exp & 1) != 0) res = (res * base) % modulo;exp = exp >> 1;base = (base * base) % modulo;}return res;}
    static long modInv(long a, long modulo){return expMod(a , modulo-2 , modulo);}
    static long mod_add(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a + b) % modulo) + modulo) % modulo;}
    static long mod_mult(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a * b) % modulo) + modulo) % modulo;}
    static long mod_sub(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a - b) % modulo) + modulo) % modulo;}
    static long mod_div(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (mod_mult(a, modInv(b, modulo), modulo) + modulo) % modulo;}
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        manas: while (t-- > 0){
            int n=sc.nextInt();
            int i;
            int[] a=new int[n];
            int[] b=new int[n];
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}
            for(i=0;i<n;i++) {b[i]=sc.nextInt();}
            ruffleSort(a);
            ruffleSort(b);
            for(i=0;i<n;i++){
                if(a[i] <= b[i]){
                    out.println(0);
                    out.flush();
                    continue manas;
                }
            }
            long ans=1;
            for(i=0;i<n;i++){
                int ct=closestRight(b[i]+1,a);
                ct=i-ct+1;
                ans = mod_mult(ans,ct,mod);
            }
            out.println(ans);
            out.flush();
        }
    }
}
