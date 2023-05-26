//package Codeforce;
//
//import java.util.*;
//import java.io.*;
//
//import static java.lang.System.out;
//
//public class LongLegs {
//    static FastRead sc = new FastRead(System.in);
//    static PrintWriter out = new PrintWriter(System.out);
//    private static class FastRead {
//        private final InputStream stream;
//        private final byte[] buf = new byte[1<<18];
//        private int curChar, numChars;
//        public FastRead (InputStream stream) {
//            this.stream = stream;
//        }
//        public FastRead (String file) throws IOException {
//            this.stream = new FileInputStream (file);
//        }
//        void run() {
//            try {
//                PrintStream fs = new PrintStream("error.txt");
//                System.setErr(fs);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        public int cscan () throws IOException {
//            if (curChar >= numChars) {
//                curChar = 0;
//                numChars = stream.read (buf);
//            }
//            if (numChars == -1)
//                return numChars;
//            return buf[curChar++];
//        }
//        public int nextInt () throws IOException {
//            int c = cscan (), sgn = 1;
//            while (space (c))
//                c = cscan ();
//            if (c == '-') {
//                sgn = -1;
//                c = cscan ();
//            }
//            int res = 0;
//            do {
//                res = (res << 1) + (res << 3);
//                res += c - '0';
//                c = cscan ();
//            }
//            while (!space (c));
//            return res * sgn;
//        }
//        public String nextString () throws IOException {
//            int c = cscan ();
//            while (space (c))
//                c = cscan ();
//            StringBuilder res = new StringBuilder ();
//            do {
//                res.appendCodePoint (c);
//                c = cscan ();
//            }
//            while (!space (c));
//            return res.toString ();
//        }
//        public double nextDouble () throws IOException {
//            int c = cscan (), sgn = 1;
//            while (space (c))
//                c = cscan ();
//            if (c == '-') {
//                sgn = -1;
//                c = cscan ();
//            }
//            double res = 0;
//            while (!space (c) && c != '.') {
//                if (c == 'e' || c == 'E')
//                    return res * exp(10, nextInt ());
//                res *= 10;
//                res += c - '0';
//                c = cscan ();
//            }
//            if (c == '.') {
//                c = cscan ();
//                double m = 1;
//                while (!space (c)) {
//                    if (c == 'e' || c == 'E')
//                        return res * exp(10, nextInt ());
//                    m /= 10;
//                    res += (c - '0') * m;
//                    c = cscan ();
//                }
//            }
//            return res * sgn;
//        }
//        public long nextLong () throws IOException {
//            int c = cscan (), sgn = 1;
//            while (space (c))
//                c = cscan ();
//            if (c == '-') {
//                sgn = -1;
//                c = cscan ();
//            }
//            long res = 0;
//            do {
//                res = (res << 1) + (res << 3);
//                res += c - '0';
//                c = cscan ();
//            }
//            while (!space (c));
//            return res * sgn;
//        }
//        public boolean space (int c) {
//            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//        }
//    }
//    static final int mod = 1_000_000_007;
//    static long mul(long a, long b) {
//        return (a * b) % mod;
//    }
//    static long exp(long base, long exp) {
//        if (exp == 0) return 1;
//        long half = exp(base, exp / 2);
//        if (exp % 2 == 0) return mul(half, half);
//        return mul(half, mul(half, base));
//    }
//    static void debug(Object... o){
//        if(o.length != 0) System.err.println(Arrays.deepToString(o));
//        else System.err.println();
//    }
//    static int cost(int l,int v,int intileg){
//        return l-intileg + v%l + v/l;
//    }
//    static int minOfThree(int a, int b, int c) {
//            if (a < b) return a < c ? a : c;
//            else return b < c ? b : c;
//    }
//    private static class Pair {
//            int key;
//            int val;
//
//            public Pair(int key, int val) {
//                this.key = key;
//                this.val = val;
//            }
//    }
//    static int optLeg(int l,int r,int v,int initleg){
//        while (l<=r){
//            if(r-l==2) {
//                int a=cost(l,v,initleg);
//                int b=cost(l+1,v,initleg);
//                int c=cost(r,v,initleg);
//                Pair[] aa={new Pair(a,l),new Pair(b,l+1),new Pair(c,r)};
//                Arrays.sort(aa,(x,y)->{if(x.key==y.key) return -x.val+y.val;
//                return x.key-y.key;});
//                return aa[0].val;
//            } // min cost and max leg length
//            if(r-l==1) return cost(l,v,initleg)<cost(r,v,initleg)?l:r;
//            if(l==r) return l;
////            debug(l+" "+r);
//            int m1=l+(r-l)/3;
//            int m2=l+2*(r-l)/3;
//            int v1=cost(m1,v,initleg),v2=cost(m2,v,initleg);
//            if(v1>v2){
//                l=m1;
//            }
//            else if(v1<v2){
//                r=m2;
//            }
//            else{
//                l=m1;r=m2;
//            }
//        }
//        return l;
//    }
//    public static void main(String[] args)throws IOException {
//        int t=sc.nextInt();
////        int i=1;
////        ArrayList<Integer> sq=new ArrayList<>();
////        while (i*i<=1e9) {
////            sq.add(i*i);
////            i++;
////        }
//        while (t-- > 0){
//            int x=sc.nextInt();
//            int y= sc.nextInt();
//            int min=Math.min(x,y);
//            int max=Math.max(x,y);
//            int intileg=1;
//            int leg=optLeg(1,min,min,intileg);
//            debug(leg);
//            long cost=leg-1 + min/leg + min%leg;
//            int l2=optLeg(1,max,max,leg);
//            debug(l2);
//            cost+=(l2-leg) + max/l2 + max%l2;
//            out.println(cost);
//            out.flush();
//        }
//    }
//}

 package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class LongLegs {
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
    static int cost(int l,int v){
        return v%l + v/l;
    }
    static int minOfThree(int a, int b, int c) {
        if (a < b) return a < c ? a : c;
        else return b < c ? b : c;
    }
    static int optLeg(int l,int r,int v){
        while (l<=r){
            if(r-l==2) {
                int a=cost(l,v);
                int b=cost(l+1,v);
                int c=cost(r,v);
                if(a<b){
                    if(a<c) return l;
                    else return r;
                }else {
                    if(b<c) return l+1;
                    return r;
                }
            }
            if(r-l==1) return cost(l,v)<cost(r,v)?l:v;
            if(l==r) return l;
            debug(l+" "+r);
            int m1=l;
            int m2=l;
            m1+=(r-l)/3;
            m2+=2*(r-l)/3;
            int v1=cost(m1,v),v2=cost(m2,v);
            if(v1>v2){
                l=m1;
            }
            else if(v1<v2){
                r=m2;
            }
            else{
                l=m1;r=m2;
            }
        }
        return l;
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
//        int i=1;
//        ArrayList<Integer> sq=new ArrayList<>();
//        while (i*i<=1e9) {
//            sq.add(i*i);
//            i++;
//        }
        while (t-- > 0){
            int x=sc.nextInt();
            int y= sc.nextInt();
            int min=Math.min(x,y);
            int max=Math.max(x,y);
            int leg=optLeg(1,min,min);
            debug(leg);
            long cost=leg-1 + min/leg + min%leg;
            int l2=optLeg(1,max,max);
            debug(l2);
            cost+=(l2-leg) + max/l2 + max%l2;
            out.println(cost);
            out.flush();
        }
    }
}