 package codeforce;

import java.util.*;
import java.io.*;

public class YetAnotherTournament {
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
        boolean val;

        public Pair(int key, boolean val) {
            this.key = key;
            this.val = val;
        }
    }
    private static class Pair1 {
        int key;
        int val;

        public Pair1(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public static class Custom_Comparator implements Comparator<Pair1> {
        //--> This is a class used to sort a Pair Array on the basis of logic you want to implement.
        //Below compare method should be implemented with care
        //e.g., if you want to sort Pair Array in terms of key in ASC. order then,
        // return o1.key-o2.key
        //similarly if you want to sort Pair Array in terms of key in DEC. order then,
        // return o2.key-o1.key
        // similar logic applies for sorting nin terms of val or any other expression, just change logic
        // to sort Pair Array, use syntax: Arrays.sort(pair_arr_var ,new Custom_ComparePair());
        // Object of Custom_ComparePair passed in Arrays.sort defines how Pair will be sorted.
        @Override
        public int compare(Pair1 o1, Pair1 o2) {
            //logic
            return o1.key-o2.key;
        }
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            Pair[] a=new Pair[n];
            Pair1[] b=new Pair1[n];
            int i;
            for(i=0;i<n;i++){
                int x=sc.nextInt();
                a[i] = new Pair(x,false);
                b[i] = new Pair1(x,i);
            }
            Arrays.sort(b,new Custom_Comparator());
            int iKilled=0;
            i=0;
            while (i<n && b[i].key<=m){
                a[b[i].val].val=true;
                iKilled++;
                m-=b[i].key;
                i++;
            }

            if(i<n && iKilled!=0 && b[i].key<=m+b[i-1].key && b[i-1].val < b[i].val){
                iKilled++;
            }
//            int currKill,pos=1;
//            for(i=n-1;i>=0;i--) {
//                currKill = i + (a[i].val?0:1);
//                if(currKill > iKilled) pos++;
//            }
            out.println(n-iKilled);
            out.flush();
        }
    }
}