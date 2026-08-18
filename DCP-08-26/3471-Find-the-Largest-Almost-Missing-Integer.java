class Solution {
    public int k1Solver(int[] arr)
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        int max= -1;

        for(int i: arr)
            map.put(i, map.getOrDefault(i, 0)+1);

        for(int key: map.keySet())
        {
            if(map.get(key)==1)
                max= Math.max(max, key);
        }
        return max;
    }

    public int largestInteger(int[] nums, int k) {
        int n= nums.length;
        if(n==1)
            return nums[0];
        if(k==n)
            return Arrays.stream(nums).max().getAsInt();

        if(k==1)
            return k1Solver(nums);
        
        int first= nums[0], ff= 0;
        int second= nums[n-1], sf= 0;

        for(int i: nums)
        {
            if(i==first)
                ff++;
            if(i==second)
                sf++;
        }

        if(ff==sf && ff==1)
            return Math.max(first, second);
        else if(ff==1)
            return first;
        else if(sf==1)
            return second;
        else 
            return -1;
    }
}