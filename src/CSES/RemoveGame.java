package CSES;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class RemoveGame {
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
//    static long gameValue(int[] a,int l,int r,boolean chance_first,long sum){ // each want to win.
//        if(l>r) return 0;
//        if(chance_first){debug(a[l]+ gameValue(a,l+1,r,false,sum-a[l]));
//            long x=a[l]+ gameValue(a,l+1,r,false,sum-a[l]);
//            long y=a[r]+gameValue(a,l,r-1,false,sum-a[r]);
//
//            if(x>y){
////                out.println("A picked: "+a[l]+" at "+l);
//                return x;
//            }
//            else {
////                out.println("A picked: "+a[r]+" at "+r);
//                return y;
//            }
//        }else {
//            long x=gameValue(a,l+1,r,true,sum-a[l]);
//            long y=gameValue(a,l,r-1,true,sum-a[r]);
//
//            long fwin=x>y?y+a[r]:x+a[l];
//            return sum-fwin;
//        }
//    }
    static long ct=0;
    static long gameValue(int[] a,int l,int r,boolean chance_first,long sum){ // each want to win.
        ct++;
        if(l>r) return 0;

         //  10 15 100 3 2 7 6 10

        if(chance_first){
            long x=gameValue(a,l+1,r,false,sum-a[l]); //choosing left how much 2nd earns
            long y=gameValue(a,l,r-1,false,sum-a[r]); // choosing right

            return x>y?(sum-y):(sum-x);
        }

        else {
            long x=gameValue(a,l+1,r,true,sum-a[l]);  //choosing left how much 1st earns
            long y=gameValue(a,l,r-1,true,sum-a[r]);

            return x>y?(sum-y):(sum-x);
        }
    }// lets get this game ready with dp
    public static void main(String[] args)throws IOException {
        int n=sc.nextInt();
        int[] a=new int[n];
        int i;
        long sum=0;
        for(i=0;i<n;i++) {a[i]=sc.nextInt();sum+=a[i];}
        out.println(gameValue(a,0,n-1,true,sum));
        debug(ct);
        out.flush();
    }
}

/*
8
10 15 100 3 2 7 6 10
 */