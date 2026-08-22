class Solution {
    public long helper(int idx, int ques[][], int n, long memo[])
    {
        if(idx >= n)
            return 0;
        
        if(memo[idx] != 0)
            return memo[idx];
        
        // solve curr question
        memo[idx]= ques[idx][0] + helper(idx+ques[idx][1]+1, ques, n, memo);

        // dont solve curr and move to next
        memo[idx]= Math.max(memo[idx], helper(idx+1, ques, n, memo));

        return memo[idx];
    }

    public long mostPoints(int[][] ques) {
        int n= ques.length;
        long memo[]= new long[n];
        memo[n-1]= ques[n-1][0];

        return helper(0, ques, n, memo);
    }
}