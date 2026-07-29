class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i=0, j=0, n= nums.length;
        int maxLen= 1;
        int or=0;

        while(j<n)
        {
            while(i<j && (or & nums[j]) != 0)
            {
                or= or ^ nums[i];
                i++;
            }
            or |= nums[j];
            maxLen= Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}