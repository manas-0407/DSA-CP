package Codeforce;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class BinaryStringToSubseq {

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

    static int[] seive(int n){
        int[] prime=new int[n+1];
        prime[0]=prime[1]=1;   //non prime 1 and prime 0.
        for(int i=2;i<=n;i++)if(prime[i] == 0) for(int j=i*i;j<=n;j+=i) prime[j]=1;
        return prime;
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

    static long expMod(long base, long exp, long modulo){ // T.C: O(log exp)
        long res = 1;
        base = base % modulo;
        if (base == 0)
            return 0;
        while (exp > 0)
        {
            if ((exp & 1) != 0)
                res = (res * base) % modulo;
            exp = exp >> 1;
            base = (base * base) % modulo;
        }
        return res;
    }
    static long modInv(long a, long modulo){
        // calculates the modulo inverse of a under modulo
        //suppose b in mod inv of a so (a * b) eqv 1 (% modulo)
        // we use fermat's theorem to get modulo inverse
        // Fermat's eq A^(p-1) eqv 1 (under % p) where p is a prime and A != x.p where x:[1,+ inf);
        // In above Fermat's eq mult with A^-1 both side so to obtain a inverse. => A^-1 eqv A^(p-2) ( % p)

        return expMod(a , modulo-2 , modulo);
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
        while (t-- > 0){
            int n=sc.nextInt();
            String s=sc.nextLine();
            ArrayList<ArrayDeque<Integer>> al=new ArrayList<>();
            al.add(new ArrayDeque<>()); // for 0
            al.add(new ArrayDeque<>()); // for 1
            int ct=1;
            StringBuilder ss=new StringBuilder();
            int i;
            for(i=0;i<n;i++){
                if(s.charAt(i) == '1'){
                    if(al.get(1).size()==0) {
                        al.get(0).add(ct);
                        ss.append(ct).append(" ");
                        ct++;
                    }else {
//                        int f=-1;
//                        for(int xx:al.get(1)){
//                            f=xx;
//                            break;
//                        }
                        int f=al.get(1).getFirst();
                        ss.append(f).append(" ");
                        al.get(1).removeFirst();
                        al.get(0).add(f);
                    }
                }
                else {
                    if(al.get(0).size()==0) {
                        al.get(1).add(ct);
                        ss.append(ct).append(" ");
                        ct++;
                    }else {
//                        int f=-1;
//                        for(int xx:al.get(0)){
//                            f=xx;
//                            break;
//                        }
                        int f=al.get(0).getFirst();
                        ss.append(f).append(" ");
                        al.get(0).removeFirst();
                        al.get(1).add(f);
                    }
                }
            }

            out.println(ct-1);
            out.println(ss);
            out.flush();
        }
    }
}
