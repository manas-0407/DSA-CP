package Codeforce;

        import java.util.*;
        import java.io.*;

public class StronglyComposite {
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

    static void primeFactors(int n) {
        while (n % 2 == 0) {
            hm.put(2, hm.getOrDefault(2, 0) + 1);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                hm.put(i, hm.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 2)
            hm.put(n, hm.getOrDefault(n, 0) + 1);
    }
    static HashMap<Integer,Integer> hm;
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0) {
            hm=new HashMap<>();
            int n=sc.nextInt();
            int[] a=new int[n];
            int i;
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}
            for(i=0;i<n;i++){
                primeFactors(a[i]);
            }
            long val=0;
            for(Map.Entry<Integer,Integer> en:hm.entrySet()){
                val+=en.getValue()/2;
                hm.put(en.getKey(),en.getValue()%2);
            }
            int one_rem=0;
            for(Map.Entry<Integer,Integer> en:hm.entrySet()){
                one_rem += en.getValue();
            }
            if((one_rem==1||one_rem==2)&&val==0){
                out.println(0);
            }else {
                val += one_rem/3;
                out.println(val);
            }
            out.flush();
        }
    }
}
