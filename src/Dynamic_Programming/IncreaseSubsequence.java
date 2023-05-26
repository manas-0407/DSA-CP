//package Dynamic_Programming;

import java.util.*;
import java.io.*;

public class IncreaseSubsequence {
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
//    static int maxLIS(int[] dp,int[] a,int index,int val){
//        if(index < 0) return 0;
//        if(dp[index] != -1) return dp[index];
//        int max=0;
//        for(int i=index-1;i>=0;i--){
//            if(a[i] < val) max=Math.max(max,maxLIS(dp,a,i,a[i]));
//        }
//        return dp[index] = max+1;
//    }
//    public static void main(String[] args)throws IOException {
//        int n=sc.nextInt();
//        int[] a=new int[n];
//        int i;
//        for(i=0;i<n;i++) {a[i]=sc.nextInt();}
//        int[] dp=new int[n]; // max at curr index dp
//        Arrays.fill(dp,-1);
//        int lis=Integer.MIN_VALUE;
//        for(i=n-1;i>-1;i--){
//            if(dp[i] == -1){
//                dp[i] = maxLIS(dp,a,i,a[i]);
//            }
//
//            lis = Math.max(lis,dp[i]);
//        }
//        out.println(lis);
//        out.flush();
//    }

    public static void main(String[] args)throws IOException {
        int n=sc.nextInt();
        long[] a=new long[n];
        int i;
        for(i=0;i<n;i++) {a[i]=sc.nextInt();}
        int[] dp=new int[n]; // max at curr index dp
        TreeMap<Long,Integer> hm=new TreeMap<>();
        for(i=0;i<n;i++){
            dp[i] = (hm.lowerKey(a[i]) != null ? dp[hm.get(hm.lowerKey(a[i]))]:0)+1 ;
            if(!hm.containsKey(a[i])) hm.put(a[i],i);
            Long next= hm.higherKey(a[i]);
            while (next!=null && dp[hm.get(next)]<=dp[i]){
                hm.remove(next);
                next = hm.higherKey(a[i]);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int xx:dp){
            max=Math.max(max,xx);
        }
        out.println(max);
        out.flush();
    }
}
// 8 1 7 2 9 3 6 4 10 5 5 6 11 7 4 8 12 9
/*
8
7 3 5 3 6 2 9 8
*/