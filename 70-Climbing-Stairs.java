class Solution {
    public int findWays(int memo[], int i, int n)
    {
        if(i>n)
            return 0;

        if(memo[i]!=0)
            return memo[i];
        
        return memo[i]= findWays(memo, i+1, n) + findWays(memo, i+2, n);
    }

    public int climbStairs(int n) {
        int memo[]= new int[n+1];
        memo[n]= 1;

        return findWays(memo, 0, n);
    }
}