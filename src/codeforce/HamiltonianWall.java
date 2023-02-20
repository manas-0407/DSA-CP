package codeforce;

import java.util.*;
import java.io.*;

public class HamiltonianWall {
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
    static void debug(Object... o){
        if(o.length != 0) System.err.println(Arrays.deepToString(o));
        else System.err.println();
    }
    public static void manas() throws IOException {
        int m=sc.nextInt();
        char[][] a=new char[2][m];
        byte[][] ck=new byte[2][m];
        int i,blcc=0;
        for(i=0;i<2;i++){
            a[i]=sc.nextString().toCharArray();
            for(int j=0;j<m;j++){
                if(a[i][j]=='B') {ck[i][j]=0;blcc++;}
                else ck[i][j]=-1;
            }
        }
        int pos1,pos2;
        pos1=pos2=Integer.MAX_VALUE;
        for(i=0;i<m;i++){
            if(ck[0][i]==-1){
                pos1=i;
                break;
            }
        }
        for(i=0;i<m;i++) {
            if (ck[1][i] == -1) {
                pos2 = i;
                break;
            }
        }
        int st;
        if(pos1==Integer.MAX_VALUE&&pos2==Integer.MAX_VALUE)st=0;
        else if(pos1<pos2){
            if(pos1%2==0)st=1;
            else st=0;
        }
        else {
            if(pos2%2==0) st=0;
            else st=1;
        }
        int col=-1;
        for(i=0;i<m;i++){
            if(ck[0][i]==0 || ck[1][i]==0) {
                col=i;
                break;
            }
        }
        if(col==-1) {
            out.println("YES");
            return;
        }
        int bc=0;
        while(true){
            bc++;
            if(bc==blcc) {
                out.println("YES");
                return;
            }
            else if(ck[(st+1)%2][col]==0) {
                ck[st][col]=1;
                st=(st+1)%2;}
            else if(ck[st][col+1]==0) {
                ck[st][col]=1;
                col++;}
            else if(bc<blcc) {
                out.println("NO");
                return;
            }
        }
    }
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- > 0) manas();
        out.close();
    }
}
