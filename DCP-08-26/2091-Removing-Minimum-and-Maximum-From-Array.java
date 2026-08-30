class Solution {
    public int minimumDeletions(int[] nums) {
        int n= nums.length;
        if(n==1 || n==2)
            return n;
        
        int max= nums[0], min= nums[0], minIdx= 0, maxIdx=0;
        for(int i=1; i<n; i++)
        {
            if(nums[i] > max)
            {
                max= nums[i];
                maxIdx= i;
            }
            if(nums[i] < min)
            {
                min= nums[i];
                minIdx= i;
            }
        }

        int leftIdx= Math.min(minIdx, maxIdx);
        int rightIdx= Math.max(minIdx, maxIdx);

        int ans= Integer.MAX_VALUE;

        // remove all from left
        ans= Math.min(ans, rightIdx+1);

        // remove all from right
        ans= Math.min(ans, n-leftIdx);

        // remove some from left and some from right;
        ans= Math.min(ans, leftIdx+1+(n-rightIdx));

        return ans;
    }
}