class Solution {
    public int helper(int sum, int nums[], int n, int target, int memo[], boolean calc[])
    {
        if(sum>target)
            return 0;

        if(calc[sum])
            return memo[sum];
        
        // loop over all the possible nums values
        for(int i: nums)
        {
            // use curr number and check for further sums
            memo[sum]+= helper(sum+i, nums, n, target, memo, calc);
        }
        calc[sum]= true;
        return memo[sum];
    }

    public int combinationSum4(int[] nums, int target) {
        int n= nums.length;
        int memo[]= new int[target+1];
        memo[target]= 1;
        boolean calc[]= new boolean[target+1];
        calc[target]= true;

        return helper(0, nums, n, target, memo, calc);  
    }
}