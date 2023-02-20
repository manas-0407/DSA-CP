package codeforce;

import java.io.*;
import java.util.*;

public class PrizeMaximzation {
    static FastRead sc = new FastRead(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    private static class FastRead {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
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

    static void manas()throws IOException{
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> a=new ArrayList<>(n);
        int i;
        for(i=0;i<n;i++) a.add(sc.nextInt());//a.set(i, sc.nextInt());
        a.sort(Comparator.comparingInt(x -> x % k)); //sorting with holding remainder sum prop..
        int j=n-1;
        long ct=0;
        i=0;
        while(i<n && a.get(i)%k==0) i++;
        boolean[] bbx=new boolean[n];
        Arrays.fill(bbx,false);
        while(i<j && j<n){
            if(k - a.get(j)%k <= a.get(i)%k) {
                ct+=(a.get(i)+a.get(j))/k;
                bbx[i]=true;
                bbx[j]=true;
                i++;
                j--;
            }
            else {
                int l=i,h=j,tgt=k-a.get(j)%k,pos=-1;
                while (l<=h){
                    int m=l+(h-l)/2;
                    if(a.get(m)%k < tgt) l=m+1;
                    else {
                        pos=m;
                        h=m-1;
                    }
                }
                if(pos==j || pos==-1) break;
                else i=pos;
            }
        }
        i=0;j=n-1;
        while(i<j&&j<n){
            while(i<j && bbx[i])i++;
            j=i+1;
            while(j<n && bbx[j])j++;
            if(i<j && j<n && bbx[i]==bbx[j] && !bbx[i]){ct+=(a.get(i)+a.get(j))/k;
            bbx[i]=bbx[j]=true;
            j=n-1;}
        }
        out.println(ct);
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while(t-- > 0) manas();
        out.close();
    }
}