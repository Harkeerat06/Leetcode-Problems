class Solution {
    int mod= 1000_000_000 + 7, total=0;
    public int helper(int i, int prev[], int memo[])
    {
        if(i==0)
            return 1;

        if(memo[i] != 0)
            return memo[i];

        long total= (2L * helper(i-1, prev, memo)) % mod;

        if(prev[i-1] != 0)
            total-= helper(prev[i-1]-1, prev, memo);

        total= ((total % mod) + mod) % mod;

        return memo[i]= (int)total;
    }

    public int distinctSubseqII(String s) {
        int n= s.length();
        int lastSeen[]= new int[26];

        // 1 based indexing
        int prev[]= new int[n];
        
        for(int i=1; i<=n; i++)
        {
            int idx= s.charAt(i-1)-'a';
            prev[i-1]= lastSeen[idx];
            lastSeen[idx]= i;
        }

        int memo[]= new int[n+1];
        
        return (helper(n, prev, memo) - 1 + mod) % mod;
    }
}