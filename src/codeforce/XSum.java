package codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class XSum {
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

    static int topleft(int[][] a,int i,int j,int[][] tl){
        if(j<0 || i<0) return 0;

        if(tl[i][j] != -1) return tl[i][j];
        else return tl[i][j] = a[i][j] + topleft(a,i-1,j-1,tl);
    }

    static int topright(int[][] a,int i,int j,int m,int[][] tr){
        if(j>=m || i<0) return 0;

        if(tr[i][j] != -1 )return tr[i][j];
        else return tr[i][j] = a[i][j] + topright(a,i-1,j+1,m,tr);
    }

    static int downleft(int[][] a,int i,int j,int n,int[][] dl){
        if(j<0 || i>=n) return 0;

        if(dl[i][j] != -1) return dl[i][j];
        else return dl[i][j]= a[i][j] + downleft(a,i+1,j-1,n,dl);
    }

    static int downright(int[][] a,int i,int j,int n,int m,int[][] dr){
        if(j>=m || i>=n) return 0;

        if(dr[i][j] != -1 ) return dr[i][j];
        else return dr[i][j]= a[i][j] + downright(a,i+1,j+1,n,m,dr);
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] a=new int[n][m];
            int i,j;
            for(i=0;i<n;i++){
                for (j=0;j<m;j++) a[i][j]=sc.nextInt();
            }

            int[][] tl=new int[n][m];
            int[][] tr = new int[n][m];
            int[][] dl = new int[n][m];
            int[][] dr=new int[n][m];
            for (int[] xx:tl) Arrays.fill(xx,-1);
            for (int[] xx:tr) Arrays.fill(xx,-1);
            for (int[] xx:dl) Arrays.fill(xx,-1);
            for (int[] xx:dr) Arrays.fill(xx,-1);
            int max=Integer.MIN_VALUE;
            for(i=0;i<n;i++){
                for (j=0;j<m;j++) {
                    max=Math.max(max,a[i][j]+topright(a,i-1,j+1,m,tr) +topleft(a,i-1,j-1,tl) + downright(a,i+1,j+1,n,m,dr) + downleft(a,i+1,j-1,n,dl));
                }
            }
            out.println(max);
            out.flush();
        }
    }
}
