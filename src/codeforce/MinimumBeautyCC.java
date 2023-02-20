package codeforce;


import java.util.*;
import java.io.*;

public class MinimumBeautyCC {
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
    static int closestRight(int x,ArrayList<Integer> arr){
            // returns index position
            int mid,i=0,j=arr.size()-1,pos=-1;
            while(i<=j){
                mid=i+((j-i)>>1);
                if(arr.get(mid) >= x){
                    pos=mid;
                    j=mid-1;
                }
                else i=mid+1;
            }
        return pos!=-1 ? arr.get(pos) : Integer.MAX_VALUE;
    }
    static int closestLeft(int x,ArrayList<Integer> arr){
            // returns index position
            int mid,i=0,j=arr.size()-1,pos=-1;
            while(i<=j){
                mid=i+((j-i)>>1);
                if(arr.get(mid) <= x){
                    pos=mid;
                    i=mid+1;
                }
                else j=mid-1;
            }
            return pos!=-1 ? arr.get(pos) : Integer.MAX_VALUE;
    }
    static int minOfThree(int a, int b, int c) {
            if (a < b) return a < c ? a : c;
            else return b < c ? b : c;
    }
    static final Random random = new Random();

    static void ruffleSort(int[] a) {
            int n = a.length;  //shuffle then sort to decrease worst case probability
            for (int i = 0; i < n; i++) {
                int oi = random.nextInt(n), temp = a[oi];
                a[oi] = a[i];
                a[i] = temp;
            }
            Arrays.sort(a);
    }
    public static void main(String[] args)throws IOException {
            int t=sc.nextInt();
            manas: while (t-- > 0){
            int n=sc.nextInt();
            int[] a=new int[n];
            int i;
            for(i=0;i<n;i++) {a[i]=sc.nextInt();}
            TreeMap<Integer,Integer> hm=new TreeMap<>();
            boolean cc=false;
            for(i=0;i<n;i++) {hm.put(a[i],hm.getOrDefault(a[i],0)+1); if(hm.get(a[i]) >= 3) cc=true;}
            if(cc){
                out.println(0);
                out.flush();
            } else {
                ruffleSort(a);
//                ArrayList<Integer> right=new ArrayList<>();
//                for(Map.Entry<Integer,Integer> en:hm.entrySet()){
//                    right.add(en.getKey());
//                }
//                hm.put(a[0],hm.get(a[0])-1);
//                if(hm.get(a[0]) <=0) right.remove((Object)a[0]);
//
//                int min=Integer.MAX_VALUE;
//                for(i=1;i<n;i++){
//                    // a[i] is median assuming
//                    hm.put(a[i],hm.get(a[i])-1);
//                    if(hm.get(a[i]) <= 0) right.remove((Object)a[i]);
////                    debug(right);
//                    for(int j=0;j<i;j++){
//
//                        if(a[j] > 2*a[i]) continue;
//                        int xx=Math.abs(a[i]*3 - a[i]+a[j]);
//                         // 3 2 1 med=2 * 3=6
//                        int v1=closestLeft(xx,right);
//                        int v2=closestRight(xx,right);
//
//
////                        if(a[j] >= a[i]){
////                            if(v1 > a[i]) v1=Integer.MAX_VALUE;
////                            if(v2 > a[i]) v2=Integer.MAX_VALUE;
////                        }
////                        else {
////                            if(v1 < a[i]) v1=Integer.MAX_VALUE;
////                            if(v2 < a[i]) v2=Integer.MAX_VALUE;
////                        }
////                        debug(v1);
////                        debug(v2);
////                        int vi=3*a[i]-a[i];
//                        min=minOfThree(min,Math.abs(3*a[i]-(a[i]+a[j]+v1)),Math.abs(3*a[i]-(a[i]+a[j]+v2)));
//                    }
//                }
//                out.println(min);
//                out.flush();
                int min=Integer.MAX_VALUE;
                for(i=1;i<n;i++) {
                    // a[i] becomes med as sorted.
                    int l = 0, r = n - 1;
                    while (l<i && r>i){
                        min=Math.min(min,Math.abs(2*a[i]-a[l]-a[r]));
                        if(a[l] + a[r] == 2*a[i]){
                            out.println(0);
                            out.flush();
                            continue manas;
                        }
                        else if(a[l] + a[r] < 2*a[i]) l++;
                        else r--;
                    }
                }
                out.println(min);
                out.flush();
            }
        }
    }
}
