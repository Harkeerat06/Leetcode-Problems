class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int dp[]= new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1]= 0;
        
        for(int i=n-1; i>=0; i--)
        {
            for(int idx= i; idx<n && idx<=nums[i]+i; idx++)
            {
                if(dp[idx]!= Integer.MAX_VALUE)
                    dp[i]= Math.min(dp[i], 1+dp[idx]);
            }
        }
        return dp[0];
    }
}