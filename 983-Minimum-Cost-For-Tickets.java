class Solution {
    public int helper(int idx, int days[], int n, int cost[], int memo[])
    {
        if(idx>=n)
            return 0;
        
        if(memo[idx]!=Integer.MAX_VALUE)
            return memo[idx];

        // take single day pass
        memo[idx]= Math.min(memo[idx], cost[0]+ helper(idx+1, days, n, cost, memo));

        // take 7 day pass
        int i= idx;
        while(i<n && days[i] <= days[idx]+6)
            i++;
        memo[idx]= Math.min(memo[idx], cost[1]+ helper(i, days, n, cost, memo));

        // take 30 day pass;
        i= idx;
        while(i<n && days[i] <= days[idx]+29)
            i++;
        memo[idx]= Math.min(memo[idx], cost[2]+ helper(i, days, n, cost, memo));

        return memo[idx];
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n= days.length;
        int memo[]= new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[n-1]= Math.min(costs[0], Math.min(costs[1], costs[2]));

        return helper(0, days, n, costs, memo);
    }
}