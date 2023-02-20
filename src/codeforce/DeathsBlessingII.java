package codeforce;

import java.util.*;
import java.io.*;

public class DeathsBlessingII {

    @SuppressWarnings("unused")
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
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

    @SuppressWarnings("unused")
    private static class Pair {
        long r;
        long d;
        public Pair(long r , long d)
        {
            this.r= r;
            this.d= d;
        }
    }

    @SuppressWarnings("unused")
    private static class Funs {
        static int gcd(int a, int b) {
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

        //modulo 10^9+7 template
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
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int x,max=Integer.MIN_VALUE;
            long sum=0;
            for(int i=0;i<n;i++) {
                x=sc.nextInt();
                sum+=x;
            }
            for(int i=0;i<n;i++) {
                x=sc.nextInt();
                sum+=x;
                if (x > max) max=x;
            }
            /* 4
             x  y   z   w
             10 100 1   20
             31<-ans
             */
            System.out.println(sum-max);
        }
    }
}
