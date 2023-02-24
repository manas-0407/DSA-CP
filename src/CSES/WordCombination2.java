package CSES;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class WordCombination2 {

    static class FastScanner {
        File filee = new File("C:\\Users\\manas\\Desktop\\inputtest.txt");
        BufferedReader br=new BufferedReader(new FileReader(filee));
        StringTokenizer st=new StringTokenizer("");

        FastScanner() throws FileNotFoundException {
        }

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

    //Code execution time calculation can be done using
    //    final long endTime = System.currentTimeMillis();   -->For initial time reference
    //    final long endTime = System.currentTimeMillis();   -->For ending time
    // Possible Case of TLE, sop being called multiple times,
    // use StringBuilder to store output and output collectively
    // in the end.
    // For WA check int <-> long conversions in code.
    // Handle Char inputs carefully when taken through continuous
    // string format input stream.Use sc.next().charAt(index) wisely.


    static class Tries{
        WordCombination.Tries[] t=new WordCombination.Tries[26]; //each position for each alpha
        boolean isLastAlpha = false;
    }

    private static class Pair {
        boolean key;
        int val;

        public Pair(boolean key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    static Pair triesSearch(String s, WordCombination.Tries root){
        for(int i=0;i<s.length();i++){
            if(root.t[s.charAt(i)-97] == null) return new Pair(false,1); // code 1 means character chain missing
            root = root.t[s.charAt(i)-97];
        }
        return new Pair(root.isLastAlpha,0); // code 0 means chain is present but not end of word
    }

    public static void main(String[] args)throws IOException {
        FastScanner sc = new FastScanner();
        String vv=sc.nextLine();
        WordCombination.Tries root = new WordCombination.Tries();
        int t=sc.nextInt();
        while (t-- > 0){
            String s=sc.nextLine();
            WordCombination.Tries ptr = root;
            for(int i=0;i<s.length();i++){
                int vm=s.charAt(i)-97;
                if(ptr.t[vm] == null) ptr.t[vm] =new WordCombination.Tries();
                ptr = ptr.t[vm];
            }
            ptr.isLastAlpha = true;
        }
        long[] dp=new long[vv.length()+1];
        Arrays.fill(dp,0);
        dp[vv.length()] = 1;
        for(int i=vv.length() -1; i>-1;i--){

            for(int j= i;j<vv.length();j++){
                String s=vv.substring(i,j+1);
                Pair ppx=triesSearch(s,root);
                if(ppx.key) {
                    dp[i]+=dp[j+1];
                    if(dp[i] > mod) dp[i] %= mod;
                }
                else if(ppx.val == 1) break;
            }
        }
        out.println(dp[0]);
        out.flush();
    }
}
