class Solution {
    public int helper(int i, int n, int[] nums, int[] dp)
    {
        if(i>=n)
            return 0;

        if(dp[i] != -1)
            return dp[i];
        
        return dp[i]= Math.max(nums[i] + helper(i+2, n, nums, dp),  helper(i+1, n, nums, dp));
    }

    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1)
            return nums[0];

        int dp[]= new int[n];
        Arrays.fill(dp, -1);

        int ans1= helper(0, n-1, nums, dp);

        Arrays.fill(dp, -1);
        int ans2= helper(1, n, nums, dp);

        return Math.max(ans1, ans2);
    }
}