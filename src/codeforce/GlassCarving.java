package Codeforce;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class GlassCarving {
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
    static void deleteMap(TreeMap<Long,Integer> hm,long key){
        if(hm.get(key) == 1) hm.remove(key);
        else hm.put(key,hm.get(key)-1);
    }
    public static void main(String[] args)throws IOException {
        int w=sc.nextInt();
        int h=sc.nextInt();
        int n=sc.nextInt();
        TreeSet<Integer> width=new TreeSet<>(),height=new TreeSet<>();
        width.add(0);
        width.add(w);
        height.add(0);
        height.add(h);
        TreeMap<Long,Integer> wd=new TreeMap<>(),hd=new TreeMap<>();
        wd.put((long)w,1);
        hd.put((long)h,1);
        while (n-- > 0){
            char c=sc.nextString().charAt(0);
            int pos=sc.nextInt();
            if(c == 'H'){
//                int pos = Integer.parseInt(s.substring(2));
                Object lower = height.lower(pos),upper = height.higher(pos);
                height.add(pos);
                if(lower==null || upper==null) continue ;
                deleteMap(hd , ((int)upper-(int)lower));
                hd.put((long)pos-(int) lower,hd.getOrDefault((long)pos-(int) lower,0)+1);
                hd.put((long)(int) upper-pos,hd.getOrDefault((long)(int)upper-pos,0)+1);
            }else {
//                int pos = Integer.parseInt(s.substring(2));
                Object lower = width.lower(pos),upper = width.higher(pos);
                width.add(pos);
                if(lower==null || upper==null) continue ;
                deleteMap(wd , ((int)upper-(int)lower));
                wd.put((long)pos-(int) lower,wd.getOrDefault((long)pos-(int) lower,0)+1);
                wd.put((long)(int) upper-pos,wd.getOrDefault((long)(int)upper-pos,0)+1);
            }
            //map.lastKey() is time saver :))
            out.println(hd.lastKey() * wd.lastKey());
            out.flush();
        }
    }
}
