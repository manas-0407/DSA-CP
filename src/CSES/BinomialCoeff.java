package CSES;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class BinomialCoeff {
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
    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }
    static long nCk(int n, int k) {

        if(k > n-k) k= n-k; //n C k == n C (n-k)
        long res = 1;
        for (int i = n - k + 1; i <= n; ++i)
            res *= i;
        for (int i = 2; i <= k; ++i)
            res /= i;
        return res;
    }
    static long expMod(long base, long exp, long modulo){ // T.C: O(log exp)
            long res = 1;
            base = base % modulo;
            if (base == 0)
                return 0;
            while (exp > 0)
            {
                if ((exp & 1) != 0)
                    res = (res * base) % modulo;
                exp = exp >> 1;
                base = (base * base) % modulo;
            }
            return res;
    }
    static long modInv(long a, long modulo) {  /* Watch out for fractional div. */
            // calculates the modulo inverse of a under modulo
            //suppose b in mod inv of a so (a * b) eqv 1 (% modulo)
            // we use fermat's theorem to get modulo inverse
            // Fermat's eq A^(p-1) eqv 1 (under % p) where p is a prime and A != x.p where x:[1,+ inf);
            // In above Fermat's eq mult with A^-1 both side so to obtain a inverse. => A^-1 eqv A^(p-2) ( % p)

            return expMod(a , modulo-2 , modulo);
    }
static int gcd(int a, int b) { // TC- O(logmax(a,b))
        if (b == 0) return a;
        return gcd(b, a % b);
}
    public static void main(String[] args)throws IOException {
//        int a=sc.nextInt();
//        int b=sc.nextInt();
//        int amb=a-b;
//        int i;
//        int factb,facta,factv,fact=1;
//        for(i=1;i<Math.max(a,b);i++){
//            fact = mul(fact,i);
//        }
//        out.println((3*333333336)%mod);
//        out.println(gcd(3, (int) (1e9+7)));
        out.println(modInv(8,mod));
        out.println((6*modInv(3L, mod))%mod);
//        out.println((1000000000+8.65) % mod);
        out.flush();
    }
}
