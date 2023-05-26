package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class PallindromeBasis {
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
    static int closestLeft(int x,ArrayList<Integer> arr){
            // returns index position
            int mid,i=0,j=arr.size()-1,pos=-1;
            while(i<=j){
                mid=i+((j-i)>>1);
                if(arr.get(mid) <= x){
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
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        ArrayList<Integer>al=new ArrayList<>();
        int i;
        i=1;
        while (i<10){
            al.add(i);
            i++;
        }
        i=11;
        while (i<100){
            al.add(i);
            i+=11;
        }
        i=1;
        while (i<10){
            int j=0;
            while (al.get(j) < 10){
                al.add(i*100 + al.get(j)*10 + i);
                j++;
            }
            i++;
        }
        i=1;
        while (i<10){
            int j=9;
            while (al.get(j) < 100){
                al.add(i*1000 + al.get(j)*10 + i);
                j++;
            }
            i++;
        }
        al.add(101);
        al.add(1001);
        Collections.sort(al);
        i=0;
        while (al.get(i)<100) i++;
        int temp=i;
        i=1;
        while (i<4){
            int j=temp;
            while (al.get(j) < 1000) {
                al.add(i*10000 + al.get(j)*10 + i);
                j++;
            }
            i++;
        }
        al.add(10001);
        Collections.sort(al);
        int size=(int) (4e4+1);
        long[] dp=new long[size];
        dp[0] = 1;
        for(int v:al){
            for(i=v;i<size;i++){
                dp[i] = mod_add(dp[i],dp[i-v],mod);
            }
        }
        while (t-- > 0){
            int n=sc.nextInt();
            out.println(dp[n]);
            out.flush();
        }
    }
}
