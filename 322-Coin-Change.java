class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int dp[][]= new int[n][amount+1];
        int INF= amount+1;

        int first= coins[0];
        for(int i=0; i<=amount; i++)
        {
            if(i%first==0)
                dp[0][i]= i/first;
            else
                dp[0][i]= INF;
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=amount; j++)
            {
                // not take
                int notTake= dp[i-1][j];

                // take
                int take= INF;
                if(j >= coins[i])
                    take= 1+ dp[i][j-coins[i]];
                
                dp[i][j]= Math.min(take, notTake);
            }
        }
        return dp[n-1][amount] == INF ? -1 : dp[n-1][amount];
    }
}