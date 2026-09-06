class Solution {
    public int helper(int sidx, int tidx, String s, String t, int slen, int tlen, int memo[][])
    {
        if(tidx >= tlen)
            return 1;
        
        if(sidx >= slen)
            return 0;
        
        if(memo[sidx][tidx] != -1)
            return memo[sidx][tidx];

        int notTake= helper(sidx+1, tidx, s, t, slen, tlen, memo);

        int take=0;
        if(s.charAt(sidx) == t.charAt(tidx))
            take= helper(sidx+1, tidx+1, s, t, slen, tlen, memo);
        
        return memo[sidx][tidx]= take + notTake;
    }

    public int numDistinct(String s, String t) {
        int slen= s.length(), tlen= t.length();
        int memo[][]= new int[slen][tlen];

        for(int i=0; i<slen; i++)
            Arrays.fill(memo[i], -1);

        return helper(0, 0, s, t, slen, tlen, memo);
    }
}