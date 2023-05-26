package Codeforce;

import java.util.*;
import java.io.*;

public class BinaryStringRepresentation {
    static FastRead sc = new FastRead(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    private static class FastRead {
        private final InputStream stream;private final byte[] buf = new byte[1<<18];private int curChar, numChars;public FastRead (InputStream stream) {this.stream = stream;}
        public FastRead (String file) throws IOException {this.stream = new FileInputStream (file);}
        void run() {try {PrintStream fs = new PrintStream("error.txt");System.setErr(fs);} catch (FileNotFoundException e) {e.printStackTrace();}} //error.txt handler
        public int cscan () throws IOException {
            if (curChar >= numChars) {curChar = 0;numChars = stream.read (buf);}if (numChars == -1) return numChars;return buf[curChar++];
        }
        public int nextInt () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}
            int res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = cscan ();} while (!space (c));return res * sgn;
        }
        public String nextString () throws IOException {
            int c = cscan ();while (space (c)) c = cscan ();StringBuilder res = new StringBuilder ();do {res.appendCodePoint (c);c = cscan ();} while (!space (c));
            return res.toString ();
        }
        public double nextDouble () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}double res = 0;
            while (!space (c) && c != '.') {if (c == 'e' || c == 'E') return res * exp(10, nextInt ()); res *= 10;res += c - '0';c = cscan ();}
            if (c == '.') {c = cscan ();double m = 1;while (!space (c)) {if (c == 'e' || c == 'E') return res * exp(10, nextInt ());m /= 10;res += (c - '0') * m;c = cscan ();}}
            return res * sgn;
        }
        public long nextLong () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}long res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = cscan ();}
            while (!space (c));return res * sgn;
        }
        public boolean space (int c) {return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;}
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
        manas: while(t-- >0){
            String s=sc.nextString();
            int x=sc.nextInt();
            int n=s.length();
            char[] a=new char[n];
            int i;
            Arrays.fill(a,'1');
            for(i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    if(i-x >= 0) a[i-x] = '0';
                    if(i+x < n) a[i+x] = '0';
                }
            }
            for(i=0;i<n;i++){
                if(s.charAt(i) == '1'){
                    if(i+x<n && i-x>=0){
                        if( a[i+x]=='0' && a[i-x]=='0'){
                        out.println(-1);
                        out.flush();
                        continue manas;}
                    }
                    else if((i+x<n && a[i+x]=='0')  || (i-x>=0 && a[i-x]=='0') || (i+x>=n && i-x<0)){
                        out.println(-1);
                        out.flush();
                        continue manas;
                    }
                }
            }
            for(char xx: a) out.print(xx);
            out.println(
            );
            out.flush();
        }
    }
}

/*
1
11111000000011001100110000010101100001011110011001111001110111110010110111111111111111001011011101110111011111111101011111011001001001100100000010000101000100110
39
 */