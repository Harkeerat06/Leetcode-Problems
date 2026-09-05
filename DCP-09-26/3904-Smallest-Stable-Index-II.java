class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        int prefixMax[]= new int[n];
        int suffixMin[]= new int[n];
        int max= Integer.MIN_VALUE, min= Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
            {
                max= Math.max(nums[i], max);
                prefixMax[i]= max;
            }

        for(int i=n-1; i>=0; i--)
            {
                min= Math.min(nums[i], min);
                suffixMin[i]= min;
            }

        for(int i=0; i<n; i++)
            {
                if(prefixMax[i] - suffixMin[i] <= k)
                    return i;
            }
        return -1;
    }
}