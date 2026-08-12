class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int aboveK= 0, i=0, j=0;
        int n= nums.length, maxLen= 1;
        
        while(j<n)  
        {
            int num= nums[j];
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num)>k)
                aboveK++;
            
            while(aboveK>0 && i<j)
            {
                map.put(nums[i], map.get(nums[i])-1);
                if(map.getOrDefault(nums[i], 0)==k)
                    aboveK--;
                i++;
            }
            maxLen= Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}