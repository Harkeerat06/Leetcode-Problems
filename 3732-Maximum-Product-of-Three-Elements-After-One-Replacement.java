class Solution {
    public long maxProduct(int[] nums) {
        long max1= Math.max(Math.abs(nums[0]), Math.abs(nums[1]));
        long max2= Math.min(Math.abs(nums[0]), Math.abs(nums[1]));
        int n= nums.length;

        for(int i=2; i<n; i++)
        {
            if(Math.abs(nums[i]) > max1)
            {
                max2= max1;
                max1= Math.abs(nums[i]);
            }
            else if(Math.abs(nums[i]) > max2)
            {
                max2= Math.abs(nums[i]);
            }
        }
        return max1 * max2 * 1_00_000;
    }
}