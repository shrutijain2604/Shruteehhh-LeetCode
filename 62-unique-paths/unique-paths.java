class Solution {
    public int uniquePaths(int m, int n) {
        Combinatorics combinatorics = new Combinatorics(m+n-2);
        return (int)combinatorics.C(m+n-2,n-1);
    }
}
class Combinatorics{
    private static final long MOD = 2147483647L;
    long[] fac;

    public Combinatorics(int n){
        this.fac = new long[n+1];
        fac[0] = 1L;
        for(int i=1;i<=n;i++) fac[i] = fac[i-1]*i%MOD;
    }

    private long powMod(long x, long n){
        if(n == 0) return 1L;
        long t = powMod(x,n/2);
        if(n%2 == 0) return t*t%MOD;
        return t*t%MOD*x%MOD;
    }

    public long C(int n,int r){
        if(r==0) return 1L;
        return (fac[n]*powMod(fac[n-r]*fac[r]%MOD,MOD-2))%MOD;
    }
}