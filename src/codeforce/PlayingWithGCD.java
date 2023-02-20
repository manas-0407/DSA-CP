package codeforce;

import java.util.*;
import java.io.*;

public class PlayingWithGCD {

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
    static class Pair {
        long r;
        long d;
        public Pair(long r , long d)
        {
            this.r= r;
            this.d= d;
        }
    }

    @SuppressWarnings("unused")
    static class Funs {
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

        static int minOfThree(int a,int b,int c){
            if(a<b) return a<c?a:c;
            else return b<c?b:c;
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

    // Possible Case of TLE, sop being called multiple times,
    // use StringBuilder to store output and output collectively
    // in the end.
    // For WA check int <-> long conversions in code.

    public static void main(String[] args)throws IOException {
        FastScanner sc=new FastScanner();
           int t=sc.nextInt();
           while(t-- > 0) {
               int n = sc.nextInt();
               int[] a = new int[n];
               int i;
               for (i = 0; i < n; i++) a[i] = sc.nextInt();
               int[] b=new int[n+1];
               b[0]=a[0];
               b[1]=a[0];
               for(i=1;i<n;i++){
                   b[i+1]=a[i];
                   int l=Funs.lcm(b[i],a[i]);
                   b[i]=l;
               }
//               System.out.println(Arrays.toString(b));
               for(i=0;i<n;i++){
                   if(Funs.gcd(b[i],b[i+1]) != a[i]) break;
               }
               if(i==n) System.out.println("YES");
               else System.out.println("NO");
           }
    }
}
