# DSA-CP
Repo for DSA and CP Problems.

# My Snippets (Handy methods)

import java.util.*;
import java.io.*;

public class Manas {
    
    static final int mod = 1_000_000_007;                                          // mod_operation
    static long expMod(long base, long exp, long modulo){ // T.C: O(log exp)
        long res = 1; base = base % modulo;if (base == 0) return 0;while (exp > 0) {if ((exp & 1) != 0) res = (res * base) % modulo;exp = exp >> 1;base = (base * base) % modulo;}return res;}
    static long modInv(long a, long modulo){return expMod(a , modulo-2 , modulo);}
    static long mod_add(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a + b) % modulo) + modulo) % modulo;}
    static long mod_mult(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a * b) % modulo) + modulo) % modulo;}
    static long mod_sub(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a - b) % modulo) + modulo) % modulo;}
    static long mod_div(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (mod_mult(a, modInv(b, modulo), modulo) + modulo) % modulo;}

    static long chineseRemainder(int[] a, int[] m) {                                          // ChineseRT
        /*
        This is a theorem that provides a way of solving a system of linear congruences
         Snippet for finding the solution to a 
         system of linear congruences using the Chinese Remainder Theorem
         */
        int M = 1;
        for (int j : m) {
            M *= j;
        }
        long x = 0;
        for (int i = 0; i < a.length; i++) {
            int Mi = M / m[i];
            x += a[i] * Mi * modInv(Mi, m[i]);
            x %= M;
        }
        return x;
    }

    static int closestLeft(int x, int[] arr) {                                          // closestLeft
        // returns index position
        int mid, i = 0, j = arr.length - 1, pos = -1;
        while (i <= j) {
            mid = i + ((j - i) >> 1);
            if (arr[mid] <= x) {
                pos = mid;
                i = mid + 1;
            } else j = mid - 1;
        }
        return pos;
    }

    static int closestRight(int x, int[] arr) {                                          // closestRight
        // returns index position
        int mid, i = 0, j = arr.length - 1, pos = -1;
        while (i <= j) {
            mid = i + ((j - i) >> 1);
            if (arr[mid] >= x) {
                pos = mid;
                j = mid - 1;
            } else i = mid + 1;
        }
        return pos;
    }

    static ArrayList<Integer> printDivisors(int n) {                                          // Divisors
        ArrayList<Integer> ans = new ArrayList<>();
        // Loop runs till square root
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (n / i == i)
                    ans.add(i);
                else {
                    ans.add(i);
                    ans.add(n / i);
                }
            }
        }
        return ans;
    }

    static TreeMap<Integer, Integer> primeFactors(int n) {                                          // Divisors_n_Power
        TreeMap<Integer, Integer> hm = new TreeMap<>(); //Replace with HashMap if order not necessary 
        // Time - O( sqrt n )
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            hm.put(2, hm.getOrDefault(2, 0) + 1);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                hm.put(i, hm.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 2)
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        //        System.out.println(hm);
        return hm;  // contain prime no which is factor as key and its power as value
    }

    static int phi(int n) {                                          // EulerTotientFun
        // function counts the number of +ve integers coprime <= n
        // phi( X ) = X-1 if X is prime
        // phi (A*B) = (A-1)(B-1) if gcd(A,B) == 1
        // Let n = p1^q1 * p2^q2 * p3^q3 ... pk^qk where pi (1<=i<=k) is prime
        // phi (n) = n*(1-1/p1)*(1-1/p2)*....*(1-1/pk) .

        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    static long exp(long base, long exp) {                                          // exp
        if (exp == 0) return 1;
        if (exp % 2 == 0) return exp(base * base, exp / 2);
        return base * exp(base, exp - 1);
    }

    static long binMultiply(long a, long b) {                                          
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1)
                ans = (ans + a);
            a = (a + a);
            b >>= 1;
        }
        return ans;
    }

    static long expBinary(long a, long b) // T.C. : O(bits count in b)                                           // expBinary
    {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = binMultiply(ans, a);
            a = binMultiply(a, a);
            b >>= 1;
        }
        return ans;
    }
    
    static int[] extendedEuclid(int a, int b) {                                          // ExtendedEuclid
         // Let gcd(a,b) = g
         // Ext Euclid's algo return x and y satisfying eq ax + by = g
        int x = 0, y = 1, u = 1, v = 0;
        while (a != 0) {
            int q = b / a;
            int r = b % a;
            int m = x - u * q;
            int n = y - v * q;
            b = a;a = r;x = u;y = v;u = m;v = n;
        }
        return new int[]{b, x, y};   // b-> gcd -> x and y is eq unknowns
    }
    
    static long floorSqrt (long x) {                                          // floorSqrt
            long ans = 0;
            for (long k = 1L << 30; k != 0; k /= 2) {
                if ((ans + k) * (ans + k) <= x) {
                    ans += k;
                }
            }
            return ans;
    }
    
    static int gcd(int a, int b) { // TC- O(logmax(a,b))                                          // gcd
            if (b == 0) return a;
            return gcd(b, a % b);
    }
    
    static boolean isPalindrome(String str)                                          // isPalindrome
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    
    static boolean isPrime(int a) {                                          // isPrime
            if (a <= 1) return false;
            if (a <= 3) return true;
            if (a % 2 == 0 || a % 3 == 0) return false;
            for (int i = 5; i * i <= a; i = i + 6)
                if (a % i == 0 || a % (i + 2) == 0)
                    return false;
            return true;
    }
    
    static int knapsack(int[] w, int[] v, int W) {                                          // Knapsack
            // w weights and v value for each corresp. weight returns max value under max weight sum pick of W
            int n = w.length;
            int[][] dp = new int[n + 1][W + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= W; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= w[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                    }
                }
            }
            return dp[n][W];
    }
    
    static int lcm(int a, int b) {                                          // lcm
        return (a / gcd(a, b)) * b;
    }
    
    static int longestCommonSubsequence(String s1, String s2) {                                          // LongestCS
            // return lenght of longest common subs int s1 and s2
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
    }
    
    
    static int minOfThree(int a, int b, int c) {                                          // minOfThree
            if (a < b) return a < c ? a : c;
            else return b < c ? b : c;
    }
    
    static long nCk_slow(int n, int k) {                                          // nCk
    
        if(k > n-k) k= n-k; //n C k == n C (n-k)
        long res = 1;
        for (int i = n - k + 1; i <= n; ++i)
            res *= i;
        for (int i = 2; i <= k; ++i)
            res /= i;
        return res;
    }
    
    static long[] factorials = new long[2_000_001];                                          // nCk_Many
    static long[] invFactorials = new long[2_000_001];
    static void preCompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mod_mult(factorials[i - 1], i,mod);
        invFactorials[factorials.length - 1] = modInv(factorials[factorials.length - 1],mod);
            for (int i = invFactorials.length - 2; i >= 0; i--)
                invFactorials[i] = mod_mult(invFactorials[i + 1], i + 1,mod);
    } 
    static long nCk(int n, int k) {
        return mod_mult(factorials[n], mod_mult(invFactorials[k], invFactorials[n - k],mod),mod);
    }
    
    
    private static class Pair { // dont use Arrays.fill to fill Class type array                                          // Pair Class
            int key;
            int val;
    
            public Pair(int key, int val) {
                this.key = key;
                this.val = val;
            }
    }
    public static class Custom_Comparator implements Comparator<Pair> {                                          // Pair Comparator
        // return o1.key-o2.key   --> Sort in Asc order
        @Override
        public int compare(Pair o1, Pair o2) {
            //logic
            return 0;
        }
    }
    
    static final Random random = new Random();
    
    static void ruffleSort(int[] a) {                                          // ruffle_Sort
            int n = a.length;  //shuffle then sort to decrease worst case probability
            for (int i = 0; i < n; i++) {
                int oi = random.nextInt(n), temp = a[oi];
                a[oi] = a[i];
                a[i] = temp;
            }
            Arrays.sort(a);
    }
    
    static class SegmentedTree { // object takes arr size as defined in constructor                                // SegmentTree
            // Change as per need
            // Use updater,builder,finder helpers
    
            int arr_size;
            int[] seg;
            public SegmentedTree(int n){
                this.seg = new int[4*n]; // Safer side 
                this.arr_size = n;
            }
            void build(int[] a,int vertex,int l,int r){ // vertex=1
                if(l==r) {
                    seg[vertex] = a[l];
                    return;
                }
                int mid= l + (r-l)/2;
    
                build(a,2*vertex,l,mid);
                build(a,2*vertex+1,mid+1,r);
                seg[vertex] = seg[vertex<<1]+seg[(vertex<<1)|1];
            }
    
            int find(int vertex,int seg_l,int seg_r,int l,int r){ // query operations here
                if(seg_l==l && seg_r==r) return seg[vertex];
                if(l>r) return 0;
                int mid= seg_l + (seg_r-seg_l)/2;
                return find(vertex<<1,seg_l,mid,l,Math.min(mid,r)) +
                        find((vertex<<1)|1,mid+1,seg_r,Math.max(mid+1,l),r);
            }
    
            void update(int vertex,int pos,int value,int seg_l,int seg_r){
                if(seg_l==seg_r) seg[vertex] = value;
                else {
                    int mid=seg_l+(seg_r-seg_l)/2;
                    if(pos<=mid) update(vertex<<1,pos,value,seg_l,mid);
                    else update(vertex<<1|1,pos,value,mid+1,seg_r);
    
                    seg[vertex] = seg[vertex<<1] + seg[(vertex<<1)|1];
                }
            }
            void builder(int[] a){
                build(a,1,0,arr_size-1);
            }
            void updater(int pos,int value){
                update(1,pos,value,0,arr_size-1);
            }
            int finder(int l,int r){
                return find(1,0,arr_size-1,l,r);
            }
    }
    
    static int[] seive(int n){                                          // seiveOfErt
        int[] prime=new int[n+1];
        prime[0]=prime[1]=1;   //non prime 1 and prime 0.
        for(int i=2;i<=n;i++)if(prime[i] == 0) for(int j=i*i;j<=n && j>-1;j+=i) prime[j]=1;
        return prime;
    }
    
    static int setBitsCt(long n)                                          // set_bit-count
    {
        int count = 0;
        while (n > 0) {
        count += n & 1;
        n >>= 1;
        }
        return count;
    }
    
    static long sqrt_floor(long x)                                          // floor_sqrt
        {
            long left = 0, right = x<=2000000123?2000000123:9223372036854775805L;
            while (right > left)
            {
                long mid = (left + right) / 2;
    
                if (mid * mid > x)
                    right = mid;
                else
                    left = mid + 1;
            }
            return left - 1;
    }
    
    
    int[][] dp= new int[n+1][17]; // height of tree							// Binary_lift
    Queue<int[]> q=new LinkedList<>(); // {node,parent}
    q.add(new int[]{root,-1});
    while (q.size() > 0){
        int node = q.peek()[0];
        int parent = q.peek()[1];
        dp[node][0] = parent;
        for(i=1;i<17;i++){  // lca[node][x] = lca[lca[node][x-1]][x-1]
            if(dp[node][i-1] == -1) dp[node][i]=-1;
            else dp[node][i] = dp[dp[node][i-1]][i-1];
        }
        for(int vv:al[node]){
            if(vv==parent) continue;
            q.add(new int[]{vv,node});
        }
        q.remove();
    }
    
    static int kth_ancestor(int Node,int k,int[][] dp){						// Kth_ancestor
            // Kth ancestor of Node
            // Using Binary manipulation
            // 110100 using LSB
            if(k==0) return Node;
            int lst_val = k&(-k);
            int lst_bit = (int) (Math.log(lst_val)/Math.log(2));
            if(dp[Node][lst_bit] == -1) return -1;
            return kth_ancestor(dp[Node][lst_bit],k^lst_val,dp);
    }
    
    static class FenwickTree {							// fenwick Tree
    
        long[] BIT; // hold fenwick tree
        int max;
    
        FenwickTree(int[] arr) { // constructor
            BIT = new long[arr.length + 1];
            max = arr.length + 1;
            for (int i = 0; i < arr.length; i++) {
                Update(i + 1, arr[i]);
            }
        }
    
        void Update(int pos, int val) {
            // if sum BIT better val be the delta value
            while (pos < max) {
                BIT[pos] += val;
                pos += pos & -pos;
            }
        }
    
        long query(int pos) {
            // 1 based BIT
            long ans = 0;
            while (pos > 0) {
                ans += BIT[pos];
                pos -= pos & -pos;
            }
            return ans;
        }
    }
    
    static boolean bellmanFord(int[][] tuple,int source,int[] dist){		// bellman
            // false if cycle is present and algo can't be applied
            // if graph is undirected check if any single edge is negative then cycle present
            // tuples of form (a,b,w) where a->b is a node with weight w, tuple[i].length = 3
            int n=dist.length-1;
            int limit = (int) 1e8;
            for(int i=1;i<=n;i++) dist[i]=limit;
            dist[source] = 0;
            for(int i=0;i<n;i++){
                for(int[] t:tuple){
                    int a=t[0],b=t[1],w=t[2];
                    dist[b] = Math.min(dist[b],dist[a]+w);
                    dist[a] = Math.min(dist[a],dist[b]+w); // Extra for undirected graph
                }
            }
    
            for(int[] t:tuple){
                int a=t[0],b=t[1],w=t[2];
                if(dist[a]!=limit && dist[a]+w < dist[b]) return false;
                if(dist[b]!=limit && dist[b]+w < dist[a]) return false;
                // cycle check
            }
            return true;
    }
    
    static void floydWarshall(int[][] dist,int[][] adj){					// floydWarshall
    
            int nodes = dist.length-1;
            for(int i=1;i<=nodes;i++){
                for(int j=1;j<=nodes;j++){
                    if(i==j) dist[i][j]=0;
                    else dist[i][j]=adj[i][j];
                }
            }
            for(int i=1;i<=nodes;i++){ // intermediate node
                for(int j=1;j<=nodes;j++){
                    for(int k=1;k<=nodes;k++){
                        dist[j][k] = Math.min(dist[j][k], dist[j][i]+dist[i][k]); // min( j -> k, j -> i -> k )
                        dist[k][j] = dist[j][k]; // for undirected
                    }
                }
            }
    }
    
    static long[] p1,p2,hash1,hash2;										// rolling_hash
    static int mod = 1000000007,b1 = 131,b2=137;
    
    static void hash_str(String s){
        int n=s.length();
        p1 = new long[n];p2=new long[n];
        p1[0]=p2[0] = 1;
        for(int i=1;i<n;i++){
            p1[i] = p1[i-1]*b1 % mod;
            p2[i] = p2[i-1]*b2 % mod;
        }
        // abcb -> a*1 + b*(b1^1) + c*(b1^2) + b*(b1^3)
        hash1 = new long[n];hash2= new long[n];
        hash1[0] = hash2[0] = s.charAt(0)-48;
        for(int i=1;i<n;i++){
            hash1[i] = ((hash1[i-1] * b1)%mod + (s.charAt(i)-48)) %mod;
            hash2[i] = ((hash2[i-1] * b2)%mod + (s.charAt(i)-48)) %mod;
        }
    }
     
    static long get_str(int l,int r){
        // inclusive l and r     
        long h1 = (hash1[r] - (l>0 ? hash1[l-1] * p1[r-l+1] % mod : 0) + mod) % mod;
        long h2 = (hash2[r] - (l>0 ? hash2[l-1] * p2[r-l+1] % mod : 0) + mod) % mod;
        // padding hash[l-1] with values to reach equal degree with hash[r];
        return ((h1<<31) | h2);
    }
    
    
    /*
       __________________
      | ________________ |
      ||                ||
      || |\  /|     ___ ||
      || | \/ | |_|   / ||
      || |    |.  |  /  ||
      ||________________||
      |__________________|
      \###################\
       \###################\
        \        ____       \
         \_______\___\_______\     
    */
}


# My Snippets (Inputs)

import java.util.*;
import java.io.*;

public class Manas_Input {
    
    // FCK SPEEDFORCES
    
    
    static FastRead sc = new FastRead(System.in);                                                   // input
    static PrintWriter out = new PrintWriter(System.out);
    private static class FastRead {
        private final InputStream stream;private final byte[] buf = new byte[1<<18];private int curChar, numChars;public FastRead (InputStream stream) {this.stream = stream;}
        public FastRead (String file) throws IOException {this.stream = new FileInputStream (file);}
        void run() {try {PrintStream fs = new PrintStream("error.txt");System.setErr(fs);} catch (FileNotFoundException e) {e.printStackTrace();}} //error.txt handler
        public int cscan () throws IOException {
            if (curChar >= numChars) {curChar = 0;numChars = stream.read (buf);}if (numChars == -1) return numChars;return buf[curChar++];}
        public int nextInt () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}
            int res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = cscan ();} while (!space (c));return res * sgn;}
        public String nextString () throws IOException {
            int c = cscan ();while (space (c)) c = cscan ();StringBuilder res = new StringBuilder ();do {res.appendCodePoint (c);c = cscan ();} while (!space (c));
            return res.toString ();}
        public double nextDouble () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}double res = 0;
            while (!space (c) && c != '.') {if (c == 'e' || c == 'E') return res * exp(10, nextInt ()); res *= 10;res += c - '0';c = cscan ();}
            if (c == '.') {c = cscan ();double m = 1;while (!space (c)) {if (c == 'e' || c == 'E') return res * exp(10, nextInt ());m /= 10;res += (c - '0') * m;c = cscan ();}}
            return res * sgn;}
        public long nextLong () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}long res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = cscan ();}
            while (!space (c));return res * sgn;}
        public boolean space (int c) {return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;}
    }
    static final int mod = 1_000_000_007;
    static long mul(long a, long b) {return (a * b) % mod;}
    static long exp(long base, long exp) {if (exp == 0) return 1;long half = exp(base, exp / 2); if (exp % 2 == 0) return mul(half, half);return mul(half, mul(half, base));}
   
    public static void main(String[] args)throws IOException {
        int t=sc.nextInt();
        while (t-- >0){
            out.println(t);
        }
        out.close();
    }
    
    // Second method using BufferedReader Class
    
    static class FastScanner2 {                                                   // cpmode
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
    
}
