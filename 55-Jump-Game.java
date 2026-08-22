class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length, nextTrue= n-1;

        for(int i=n-2; i>=0; i--)
        {
            if(nextTrue <= i+nums[i])
                nextTrue= i;
        }
        return nextTrue==0;
    }
}