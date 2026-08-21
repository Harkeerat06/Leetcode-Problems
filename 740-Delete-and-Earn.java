class Solution {
    public int helper(int idx, int nums[][], int n, int memo[])
    {
        if(idx >= n)
            return 0;
        
        if(memo[idx]!=0)
            return memo[idx];

        // take the element
        if(nums[idx][0]+1 != nums[idx+1][0])
            memo[idx]= Math.max(memo[idx], (nums[idx][0]*nums[idx][1]) + helper(idx+1, nums, n, memo));
        else
            memo[idx]= Math.max(memo[idx], (nums[idx][0]*nums[idx][1]) + helper(idx+2, nums, n, memo));


        // dont take and check for next element
        memo[idx]= Math.max(memo[idx], helper(idx+1, nums, n, memo));

        return memo[idx];
    }

    public int deleteAndEarn(int[] arr) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i: arr)
        {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int n= map.size();
        int nums[][]= new int[n][2];

        int idx=0;
        for(int i: map.keySet())
        {
            nums[idx][0]= i;
            nums[idx][1]= map.get(i);
            idx++;
        }
        Arrays.sort(nums, (a,b)-> Integer.compare(a[0], b[0]));
        int memo[]= new int[n];
        memo[n-1]= nums[n-1][1]*nums[n-1][0];

        return helper(0, nums, n, memo);
    }
}