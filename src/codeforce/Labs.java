package codeforce;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Labs {
    static class FastRead {
        final private int BUFFER_SIZE = 1 << 18;
        final private DataInputStream din;
        final private byte[] buffer;
        private PrintWriter pw;
        private int bufferPointer, bytesRead;
        StringTokenizer st;

        public FastRead() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastRead(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        void run(){
            try{
                PrintStream fs=new PrintStream("error.txt");
                System.setErr(fs);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

        public void streamOutput(String file) throws IOException {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        }

        public void println(String a) {
            pw.println(a);
        }

        public void print(String a) {
            pw.print(a);
        }

        public String nextLine() throws IOException {
            byte[] buf = new byte[3000064]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
            if (pw != null) pw.close();
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(out));
        }

        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    @SuppressWarnings("unused")
    public static class Custom_Comparator implements Comparator<Pair>{
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
            return 0;
        }
    }

    @SuppressWarnings("unused")
    private static class Pair {
        int key;
        int val;
        public Pair(int key , int val)
        {
            this.key= key;
            this.val= val;
        }
    }

    static void debug(Object... o){
        if(o.length != 0) System.err.println(Arrays.deepToString(o));
        else System.err.println();
    }

    static int gcd(int a, int b) { // TC- O(logmax(a,b))
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static int binary(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) return m;
            if (arr[m] < x) l=m+1;
            else r=m-1;
        }
        return -1;
    }

    static ArrayList<Integer> printDivisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Loop runs till square root
        int sqrt = (int)Math.sqrt(n);
        for (int i=1; i<=sqrt; i++) {
            if (n%i==0) {
                if (n/i == i)
                    ans.add(i);
                else {
                    ans.add(i);
                    ans.add(n/i);
                }
            }
        }
        return ans;
    }

    static double logxBasey(int x, int y) {
        return (Math.log(x) / Math.log(y));
    }

    static int minOfThree(int a,int b,int c){
        if(a<b) return a<c?a:c;
        else return b<c?b:c;
    }

    static long nCk(int n, int k) {
        long res = 1;
        for (int i = n - k + 1; i <= n; ++i)
            res *= i;
        for (int i = 2; i <= k; ++i)
            res /= i;
        return res;
    }

    static boolean isPrime(int a) {
        if (a<=1)  return false;
        if (a<=3)  return true;
        if (a%2 == 0 || a%3 == 0) return false;
        for (int i=5; i*i<=a; i=i+6)
            if (a%i == 0 || a%(i+2) == 0)
                return false;
        return true;
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

    static final int mod = 1_000_000_007;

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    //Code execution time calculation can be done using
    //    final long endTime = System.currentTimeMillis();   -->For initial time reference
    //    final long endTime = System.currentTimeMillis();   -->For ending time
    // For WA check int <-> long conversions in code.
    // Handle Char inputs carefully when taken through continuous
    // string format input stream.Use sc.next().charAt(index) wisely.

    private static void manas(FastRead sc,FastWriter out)throws IOException{

    }

    public static void main(String[] args){
        try {
            FastRead sc = new FastRead();
            FastWriter out = new FastWriter();
            // sc.run(); //-->Uncomment to print debug result in error.txt file and not on console
            manas(sc,out);
            sc.close();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

/*
int n=sc.nextInt();
//        StringBuilder[] out =new StringBuilder[n];
        int[][] a=new int[n][n];
        int k=n*n,i,j;
//        for(i=0;i<n;i++){
//            a[i][a[i].length-1] =new StringBuilder();
//        }
        i=0;j=0;
        boolean b=true;
        while(k != 0){
//            out[i].append(k).append(" ");
//            debug(out[i]);
            a[i][j] = k;
            if(b) i++;
            else i--;
            if(k%n==1) {
                if(b) {
                    b=false ; i--;
                }
                else {
                    b=true; i++;
                }
                j++;
            }
            k--;
            debug(i);
        }
        StringBuilder ans=new StringBuilder();
//        for(StringBuilder each: out){
//            ans.append(each).append("\n");
//        }
        for(int[] x: a){
            for(int ele:x)
                ans.append(ele).append(" ");
            ans.append("\n");
        }
        System.out.println(ans);
        // code end
 */