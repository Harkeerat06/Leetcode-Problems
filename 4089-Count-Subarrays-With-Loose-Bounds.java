class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n= nums.length;
        long count=0;
        int i=0, j=0;

        while(j<n)
        {
            while(j<n && nums[j] >= minK && nums[j] <= maxK)
                j++;

            long len= j-i;
            count+= len * (len+1) / 2;
            j++;
            i=j;
        }
        return count;
    }
}