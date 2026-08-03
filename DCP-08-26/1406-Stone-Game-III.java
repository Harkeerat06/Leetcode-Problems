class Solution {
    public int helper(int arr[], int dp[], int idx, int n)
    {
        if(idx>=n)
            return 0;
        
        if(dp[idx] != Integer.MIN_VALUE)
            return dp[idx];

        int a= arr[idx];
        int sum=0;
        
        for(int j=0; idx+j<n && j<3; j++)
        {
            sum+= arr[idx+j];
            int next= helper(arr, dp, idx+j+1, n);
            dp[idx]= Math.max(dp[idx], sum - next);
        }

        return dp[idx];
    }
    public String stoneGameIII(int[] stoneValue) {
        int n= stoneValue.length;
        int dp[]= new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n]= 0;

        int maxDiff= helper(stoneValue, dp, 0, n);

        if(maxDiff>0)
            return "Alice";
        else if(maxDiff==0)
            return "Tie";
        else
            return "Bob";
    }
}