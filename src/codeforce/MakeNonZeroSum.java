package codeforce;

import java.util.*;
import java.io.*;

public class MakeNonZeroSum {

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

    //~~manas_rai
    //Code execution time calculation can be done using
    //    final long endTime = System.currentTimeMillis();   -->For initial time reference
    //    final long endTime = System.currentTimeMillis();   -->For ending time
    // Possible Case of TLE, sop being called multiple times,
    // use StringBuilder to store output and output collectively
    // in the end.
    // For WA check int <-> long conversions in code.
    // Handle Char inputs carefully when taken through continuous
    // string format input stream.Use sc.next().charAt(index) wisely.

    static void arrswap(int[] n){
        int t=n[0];
        n[0]=n[1];
        n[1]=t;
    }

    public static void main(String[] args)throws IOException {
        FastScanner sc=new FastScanner();
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int[] a =new int[n];
            int [] one = new int[2];
            int[] m_one=new int[2]; //0->even ct 1--> odd ct
            int i;
            for(i=0;i<n;i++){
                a[i]=sc.nextInt();
                if(a[i] == 1) one[(i+1)%2==1 ? 1 : 0] ++;
                else m_one[((i+1)%2==1)?1:0]++;
            }

//            if(n%2 == 1) {
//                System.out.println(-1);
//                continue;}
//            System.out.println("ONE: "+ Arrays.toString(one));
//            System.out.println("MONE: "+ Arrays.toString(m_one));
            int sum=0,remsum,y;
            boolean b=true;
            for(i=0;i<n;i++){
                if((i+1)%2==0) sum-=a[i];
                else sum=sum+a[i];

                if(a[i] == -1){
                    if((i+1) % 2 == 1) y=1;
                    else y=0;
                    if(!b){
                        y=1-y;
                        b=true;
                    }
                    else b=false;
                    m_one[y] --;
                }
                else {
                    if((i+1)%2 == 1) y=1;
                    else y=0;
                    if(!b){
                        y=1-y;
                        b=true;
                    }
                    else b=false;
                    one[y] --;

                }
                arrswap(one);
                arrswap(m_one);
                remsum=one[1]+m_one[0]-(one[0]+m_one[1]);
                if(sum+remsum == 0){
                    break;
                }
//                System.out.println("sum: "+sum);
//                System.out.println("Rem sum: "+remsum);

//                System.out.println("ONE: "+ Arrays.toString(one));
//                System.out.println("MONE: "+ Arrays.toString(m_one));
//                System.out.println();
            }
            if(i==n){
                System.out.println(-1);
            }
            else if(i==n-1){
                System.out.println(1);
                System.out.println(1+" "+n);
            }
            else {
                System.out.println(2);
                System.out.println(1 + " " + (i + 1));
                System.out.println((i + 2) + " " + n);
//            System.out.println("\n\n");
            }
//            Arrays.sort(a);
        }
    }
}
