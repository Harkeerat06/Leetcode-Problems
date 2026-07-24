class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int xors[]= new int[2048];
        int n= nums.length;

        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                xors[nums[i] ^ nums[j]] = 1;
            }
        }

        int ans[]= new int[2048];
        for(int i: nums)
        {
            for(int j=0; j<2048; j++)
            {
                if(xors[j]==1)
                    ans[j ^ i]= 1;
            }
        }
        
        int count=0;
        for(int i: ans)
        {
            if(i==1)
                count++;
        }
        return count; 
    }
}                                                   