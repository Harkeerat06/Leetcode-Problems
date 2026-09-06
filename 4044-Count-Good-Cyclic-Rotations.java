class Solution {
    public int countGoodRotations(int[] nums) {
        int n= nums.length;
        long firstN=0, total=0;

        for(int i=0; i<n; i++)
        {
            if(i<n/2)
                firstN+= nums[i];

            total+= nums[i];
        }

        int count=0, i=0, j=n/2 - 1;

        while(i<n)
        {
            if(firstN > total-firstN)
                count++;

            // remove first num
            firstN-= nums[i%n];
            i++;
            
            j++;
            firstN+= nums[j%n];
        }
        return count;
    }
}