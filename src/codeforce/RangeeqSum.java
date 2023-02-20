package codeforce;

import java.util.*;
import java.io.*;

public class RangeeqSum {

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");

        void run(){
            try{
                PrintStream fs=new PrintStream("error.txt");
                System.setErr(fs);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    private static class Pair {
        long key;
        long val;
        public Pair(long key , long val)
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
            for(int i=2;i*i <= a;i++)
                if(a%i == 0) return false;
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
    // Possible Case of TLE, sop being called multiple times,
    // use StringBuilder to store output and output collectively
    // in the end.
    // For WA check int <-> long conversions in code.
    // Handle Char inputs carefully when taken through continuous
    // string format input stream.Use sc.next().charAt(index) wisely.

    public static void main(String[] args)throws IOException {
        FastScanner sc=new FastScanner();
        //sc.run(); //-->Uncomment to print debug result in error.txt file and not on console
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            StringBuilder st=new StringBuilder();
            if((n&1)==0){
                int k=n/2;
                while(k<n){
                    st.append(k).append(" ");
                    st.append(k+(n/2+1)).append(" ");
                    k++;
                }
            }
            else {
                int k=n/2+1;
                while(k<n){
                    st.append(k+1).append(" ");
                    st.append((k+3+n/2)).append(" ");
                    k++;
                }
                st.append(k+3+n/2);

                // Multiple sop cause of TLE
            }
            System.out.println(st);
        }
    }
}
