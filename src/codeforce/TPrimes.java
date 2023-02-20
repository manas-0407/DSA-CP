//package codeforce;
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.util.*;
////
////public class TPrimes {
////
////    static class FastScanner {
////        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st=new StringTokenizer("");
////        String next() {
////            while (!st.hasMoreTokens())
////                try {
////                    st=new StringTokenizer(br.readLine());
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            return st.nextToken();
////        }
////
////        int nextInt() {
////            return Integer.parseInt(next());
////        }
////
////        long nextLong(){
////            return Long.parseLong(next());
////        }
////    }
////
////    public static void main(String[] args) {
////        FastScanner fs=new FastScanner();
////        int n= fs.nextInt();
////        boolean[] ar=new boolean[1000001];
////        int i,j;
////        Arrays.fill(ar,true);
////        ar[0]=false;
////        ar[1]=false;
////        for(i=2;i*i<ar.length;i++)
////        {
////            if(ar[i])
////            {
////                for(j=i*i;j<ar.length;j+=i)
////                {
////                    ar[j]=false;
////                }
////            }
////        }
////        while(n-- > 0)
////        {
////
////            long x=fs.nextLong();
////            double sqr =Math.sqrt(x);
////            int y=(int) sqr;
////            if(sqr==Math.ceil(sqr) && ar[y])
////                System.out.println("YES");
////            else
////                System.out.println("NO");
////        }
////    }
////}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.Random;
//import java.util.StringTokenizer;
//
//static class FastScanner {
//    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st=new StringTokenizer("");
//    String next() {
//        while (!st.hasMoreTokens())
//            try {
//                st=new StringTokenizer(br.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        return st.nextToken();
//    }
//
//    int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    long nextLong(){
//        return Long.parseLong(next());
//    }
//}
//
//static int gcd(int a, int b) {
//    if (b == 0) return a;
//    return gcd(b, a % b);
//}
//
//static long exp(long base, long exp) {
//    if (exp==0) return 1;
//    long half=exp(base, exp/2);
//    if (exp%2==0) return mul(half, half);
//    return mul(half, mul(half, base));
//}
//
//static final Random random=new Random();
//
//static void ruffleSort(int[] a) {
//    int n=a.length;//shuffle, then sort
//    for (int i=0; i<n; i++) {
//        int oi=random.nextInt(n), temp=a[oi];
//        a[oi]=a[i]; a[i]=temp;
//    }
//    Arrays.sort(a);
//}
//
////modulo 10^9+7 template
//
//static final int mod=1_000_000_007;
//
//static long add(long a, long b) {
//    return (a+b)%mod;
//}
//static long sub(long a, long b) {
//    return ((a-b)%mod+mod)%mod;
//}
//static long mul(long a, long b) {
//    return (a*b)%mod;
//}