class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min= nums[0], max= nums[0], n= nums.length;
        HashSet<Integer> set= new HashSet<>();

        for(int i: nums)
        {
            max= Math.max(max, i);
            min= Math.min(min, i);
            set.add(i);
        }

        List<Integer> ans= new ArrayList<>();
        for(int i=min+1; i<max; i++)
        {
            if(!set.contains(i))
                ans.add(i);
        }
        return ans;
    }
}