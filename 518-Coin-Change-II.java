class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int dp[][]= new int[n][amount+1];

        dp[0][0]= 1;
        
        for(int i=coins[0]; i<=amount; i+=coins[0])
        {
            dp[0][i]= dp[0][i-coins[0]];
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=amount; j++)
            {
                // not take
                int notTake= dp[i-1][j];

                // take
                int take= 0;
                if(j >= coins[i])
                    take= dp[i][j-coins[i]];
                
                dp[i][j]= take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}