class Solution {
    public int peakValleyDifference(int[] nums) {
        int sumValley=0;
        int sumPeak=0;

        for(int i=1; i<nums.length-1; i++)
        {
            // peak
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1])
                sumPeak+= nums[i];

            if(nums[i-1] > nums[i] && nums[i] < nums[i+1])
                sumValley+= nums[i];
        }
        return sumPeak- sumValley;
    }
}