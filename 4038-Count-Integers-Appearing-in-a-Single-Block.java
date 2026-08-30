class Solution {
    public int countSpecialIntegers(int[] nums) {
        int score=0, n= nums.length;
        if(n==1)
            return 1;

        for(int i=1; i<101; i++)
            {
                int j=0;
                while(j<n && nums[j]!=i)
                    j++;

                if(j==n)
                    continue;
                
                // get end point
                while(j<n &&nums[j]==i)
                    j++;

                if(j==n)
                {
                    score++;
                    continue;
                }

                // check if i is present again
                boolean isPresent= false;
                while(j<n)
                    {
                        if(nums[j]==i)
                        {
                            isPresent=true;
                            break;
                        }
                        j++;
                    }
                if(!isPresent)
                    score++;
            }
        return score;
    }
}