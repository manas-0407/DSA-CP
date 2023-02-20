package codeforce;

import java.util.*;
import java.io.*;

public class SortTheArray {

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

    public static void main(String[] args)throws IOException {
        FastScanner sc=new FastScanner();
     int n=sc.nextInt();
     int[] a=new int[n];
     int i;
     for (i=0;i<n;i++){
         a[i]=sc.nextInt();
     }
     int s=0,e=0;
     boolean b=false;
     int c=0;
     for(i=1;i<n;i++) {
         if (a[i] < a[i - 1] && !b) {
             s = i-1 ;
             b = true;
             c++;
         }
         else if (a[i] > a[i - 1] && b) {
                 e = i-1 ;
                 b = false;

         }
         if (c > 1) break;
     }
     if(b) e=n-1;
//        System.out.println(s+" "+e);
     if(i!=n) System.out.println("no");
     else {
         if(s==0 && e==n-1) {
             System.out.println("yes");
             System.out.println((s + 1) + " " + (1 + e));
         }
         else if(s==0 ) {
             if (a[s] < a[e+1]){
             System.out.println("yes");
             System.out.println((s + 1) + " " + (1 + e));}
             else System.out.println("no");
         }
        else if(e==n-1 ) {
            if (a[e] > a[s-1]) {
                System.out.println("yes");
                System.out.println((s + 1) + " " + (1 + e));
            }
            else{
                System.out.println("no");
            }
         }
         else if(a[s] < a[e+1] && a[e] > a[s-1]) {
             System.out.println("yes");
             System.out.println((s + 1) + " " + (1 + e));
         }
        else
             System.out.println("no");
     }
    }
}
