package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class AlmostIncreasingSubsequence {
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
            int val;

            public Pair(int key, int val) {
                this.key = key;
                this.val = val;
            }
    }
    public static void main(String[] args)throws IOException {
//        int t=sc.nextInt();
//        while (t-- > 0){
            int n=sc.nextInt();
            int[] a=new int[n];
            int q=sc.nextInt();
            int i;
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}

//            TreeSet<Integer> opening=new TreeSet<>(),closing=new TreeSet<>();
//            i=0;
//            int[] getct=new int[n];
//            int[] diffarr=new int[n];
//            Arrays.fill(getct,0);
//            Arrays.fill(diffarr,0);
//
//            for(i=0;i<n;i++){
//                int xx=a[i];
//                int ct=0;
//                int st=i;
//                while (i<n && a[i]<=xx){
//                    xx=a[i];
//                    i++;
//                    ct++;
//                }
//                if (ct >= 3) {
//                    opening.add(st+1);
//                    closing.add(i);
//                    getct[st]=1;
//                    for(int j=st;j<i;j++) diffarr[j] = 1;
//                }
//                i--;
//            }
//            for(i=1;i<n;i++){
//                getct[i] = getct[i]+getct[i-1];
//                diffarr[i]=diffarr[i]+diffarr[i-1];
//            }
//
//            while (q-- > 0){
//                int l=sc.nextInt();
//                int r=sc.nextInt();
//                int free=0;
//                Integer cl=closing.higher(l-1);
//                if(cl != null)
//                {
//                    if (cl - l >= 2) free += 2;
//                    else free += cl - l + 1;
//                }
//                Integer op=opening.lower(r+1);
//                if(op != null)
//                {
//                    if (r - op >= 2) free += 2;
//                    else free += r - op + 1;
//                }
//            }


            Pair[] p=new Pair[n]; // key -> ct of seq, val-> 1 chain

            for(i=0;i<n;i++) p[i] = new Pair(0,0);
            TreeMap<Integer,Integer> st2ed = new TreeMap<>(),ed2st=new TreeMap<>();
            for(i=0;i<n;i++){
                int xx=a[i];
                int ct=0;
                int st=i;
                while (i<n && a[i]<=xx){
                    xx=a[i];
                    i++;
                    ct++;
                }
                if (ct >= 3) {
                    st2ed.put(st+1 , i);
                    p[st].key=1;
                    for(int j=st;j<i && j<n;j++) {
                        p[j].val = 1;
                    }
                }
                i--;
            }

            for(i=1;i<n;i++){
                p[i].key = p[i].key + p[i-1].key;
                p[i].val = p[i].val + p[i-1].val;
            }

            for(Map.Entry<Integer,Integer> en:st2ed.entrySet()){
                ed2st.put(en.getValue(),en.getKey());
            }

            while (q-- > 0){

                int l=sc.nextInt();
                int r=sc.nextInt();

                Integer l_high = ed2st.higherKey(l-1);
                Integer r_low = st2ed.lowerKey(r+1);
//                debug(l_high + "  "+r_low);
                int ct=0;
                if(l_high!=null && ed2st.get(l_high)<l && l_high<=r){
                    ct+= l_high-l+1 >= 3?2:l_high-l+1;
                    l=l_high+1;
                }
                if(r_low != null && st2ed.get(r_low)>r && r_low>=l){
                    ct += r-r_low+1 >= 3 ? 2 : r-r_low+1;
                    r=r_low -1 ;
                }
                if(l>r){
                    out.println(ct);
                }else {
                    if(r_low!=null && l>r_low && l_high!=null&&r<l_high){
                        out.println(r-l+1 >= 3 ? 2 : r-l+1);
                    }else {
                        ct += (r-l+1)-((r-1>=0?p[r-1].val:0) -(l-2>=0?p[l-2].val:0));
                        ct+=2*(p[r-1].key- (l-2>=0?p[l-2].key:0));
                        out.println(ct);
                    }
                }
                out.flush();
            }
//        }
    }
}

/*
9 8
1 2 4 3 3 5 6 2 1
1 3
1 4
2 5
6 6
3 7
7 8
1 8
8 8
 */


/*
5 1
3 3 3 3 3
1 5
 */