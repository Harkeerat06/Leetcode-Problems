class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int ans= -1;
        int n= nums.length;
        
        for(int i=0; i<=n-1; i++)
            {
                int max= nums[0];
                int min= nums[i];

                for(int j=1; j<=i; j++)
                    {
                        if(nums[j]>max)
                        {
                            max= nums[j];
                        }
                    }
                for(int j=i; j<=n-1; j++)
                    {
                        if(nums[j]<min)
                        {
                            min= nums[j];
                        }
                    }
                
                if(max - min <= k)
                    return i;
            }
        return ans;
    }
}