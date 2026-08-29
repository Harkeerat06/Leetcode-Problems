class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length, sum=0;
        for(int i: nums)
            sum+= i;
        
        if(sum%2!=0)
            return false;

        int target= sum/2;
        boolean dp[][]= new boolean[n][target+1];
        for(int i=0; i<n; i++)
            dp[i][0]= true;

        if(nums[0]<=target)
            dp[0][nums[0]]= true;

        for(int i= 1; i<n; i++)
        {
            for(int j= target; j>0; j--)
            {
                // not take
                boolean notTake= dp[i-1][j];

                // take
                boolean take= false;
                if(j >= nums[i])
                    take= dp[i-1][j-nums[i]];

                dp[i][j]= take || notTake; 
            }
        }
        return dp[n-1][target];
    }
}