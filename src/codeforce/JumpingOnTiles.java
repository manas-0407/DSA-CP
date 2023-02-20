package codeforce;

import java.util.*;
import java.io.*;

public class JumpingOnTiles {
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
        if(o.length != 0) System.err.print(Arrays.deepToString(o));
        else System.err.println();
    }
    private static class Pair {
            char key;
            int val;

            public Pair(char key, int val) {
                this.key = key;
                this.val = val;
            }
    }
    public static class Custom_Comparator implements Comparator<Pair> {
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
            public int compare(Pair o1, Pair o2) {
                //logic
                if(o1.key-o2.key == 0) return o1.val-o2.val;  // if same then Asc of index
                return o1.key-o2.key; // Asc of alpha.
            }
    }
    public static class Custom_Comparator1 implements Comparator<Pair> {
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
            public int compare(Pair o1, Pair o2) {
                //logic
                if(o1.key-o2.key == 0) return o1.val-o2.val;  // if same then Asc of index
                return o2.key-o1.key; // Dec of alpha.
            }
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0){
            String s=sc.nextString();
            int n=s.length();
            Pair[] p=new Pair[n];
            int i;
            for(i=0;i<n;i++) {
                p[i] = new Pair(s.charAt(i),i+1);
            }
            boolean b= s.charAt(0) < s.charAt(n-1); // last is bigger then true  c->l
            if(b){
                Arrays.sort(p,new Custom_Comparator());
            }
            else {
                Arrays.sort(p,new Custom_Comparator1());
            }
//            for (Pair xx:p) debug(xx.key+"  "+xx.val);
            int start=-1,end=-1;
            for(i=0;i<n;i++) {
                if(p[i].key == s.charAt(0) && start==-1){
                    start=i;
                }
                if(p[i].key == s.charAt(n-1) && end==-1){
                    while (i<n-1 && p[i+1].key == p[i].key) i++;
                    end=i;
                }
            }
            StringBuilder ans=new StringBuilder();
            long step=0,count=0;
            for(i=start;i<=end;i++){
                if(i<end) {count+=Math.abs(p[i].key-p[i+1].key);}
                ans.append(p[i].val).append(" ");
                step++;
            }
            out.println(count+" "+step);
            out.println(ans);
            out.flush();
        }
    }
}
