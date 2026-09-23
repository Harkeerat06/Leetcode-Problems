class Solution {
    public int minOperations(int[] nums, int x) {
        int n= nums.length, total=0;
        
        for(int i=0; i<n; i++)
        {
            total+= nums[i];
        }

        int target= total-x;
        int i=0, j=0, sum=0;
        int maxLen_sum= 0, maxLen=-1;

        while(j<n)
        {
            sum+= nums[j];

            while(i<=j && sum>target)
            {
                sum-= nums[i];
                i++;
            }

            if(j-i+1 > maxLen && sum==target)
            {
                maxLen= j-i+1;
            }
            j++;
        }

        if(maxLen!=-1)
            return n-maxLen;
        
        return -1;
    }
}