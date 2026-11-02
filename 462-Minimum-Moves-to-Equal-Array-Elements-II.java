class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums); 
        int median= nums[n/2], moves=0;   
    
        for(int i: nums)
        {
            moves+= Math.abs(median - i);
        }
        return moves;
    }
}