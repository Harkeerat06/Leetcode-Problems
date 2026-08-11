class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int n= nums.length, sum=nums[0];
        for(int i: nums)
            set.add(i);

        for(int i=1; i<n; i++)
        {
            if(nums[i-1]+1 != nums[i])
                break;
            
            sum+= nums[i];
        }

        while(set.contains(sum))
            sum++;
        
        return sum;
    }
}