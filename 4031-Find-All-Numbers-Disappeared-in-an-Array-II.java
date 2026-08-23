class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans= new ArrayList<>();
        int n= nums.length, currStart=lower;
        Arrays.sort(nums);

        for(int i=0; i<n; i++)
        {
            int num= nums[i];

            if(num<lower || num>upper)
                continue;
            
            if(num>upper)
                break;
            
            if(num>currStart)
                ans.add(Arrays.asList(currStart, Math.min(upper, num-1)));
            currStart= num+1;
        }
        if(currStart <= upper)
        {
            ans.add(Arrays.asList(currStart, upper));
        }
        return ans;
    }
}