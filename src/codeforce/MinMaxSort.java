package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class MinMaxSort {
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
            int[] a = new int[n];
            int i;
            for (i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            // to find sorted length from the centre
            int mid = n % 2 == 0 ? n / 2 : n / 2 + 1;
            for(i=0;i<n;i++){
                if(a[i] == mid) break;
            }
            int l=i,r=i;
            int v1,v2;
            if(n%2 == 0){
                v1=mid;v2=mid+1;
            }else {
                v1=mid;
                v2=mid;
            }
            int counter=0;
            while (l>-1 && r<n){
                while (l>-1 && a[l] != v1) l--;
                while (r<n && a[r] != v2) r++;
                if(l>-1 && r<n) {
                    v1--;v2++;
                    counter++;
                }
            }
            out.println(n%2==0 ? n/2 - counter : n/2 +1 - counter);
            out.flush();
//            Deque<Integer> dq = new ArrayDeque<>();
//            for(i=0;i<n;i++){
//                if(a[i] == mid) break;
//            }
//            dq.addFirst(mid);
//            int k=mid-1;
//            int pos=i;
//            for(;i>-1;i--){
//                if(a[i] == k){
//                    dq.addFirst(k);
//                    k--;
//                }
//            }
//            k=mid+1;
//            for(i=pos+1;i<n;i++){
//                if(a[i] == k){
//                    dq.addLast(a[i]);
//                    k++;
//                }
//            }
//            debug(dq);
//            if(n%2==0){
//                int pdq=1;
//                for(int x:dq){
//                    if(x==mid) break;
//                    pdq++;
//                }
//                mid = dq.size()/2;
//                if(pdq > mid){
//                    for(i=pdq-mid;i>-1;i--) dq.removeFirst();
//                }
//                else if(pdq < mid) for (i=mid-pdq;i>-1;i--) dq.removeLast();
//            }else { // 2 4 6
//                int pdq=1;
//                for(int x:dq){
//                    if(x==mid) break;
//                    pdq++;
//                }
//                if(pdq > mid){
//                    for(i=pdq-mid;i>-1;i--) dq.removeFirst();
//                }
//                else if(pdq < mid) for (i=mid-pdq;i>-1;i--) dq.removeLast();
//            }
//        }

        }
    }
}
