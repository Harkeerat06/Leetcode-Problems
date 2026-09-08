class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n= arr.length;
        int dp[]= new int[n];
        int count[]= new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen= 1;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(arr[j]<arr[i])
                {
                    if(dp[j]+1 == dp[i])
                        count[i]+= count[j];
                    
                    else if(dp[i] <= dp[j])
                    {
                        dp[i]= dp[j]+1;
                        count[i]= count[j];
                    }
                }
                maxLen= Math.max(maxLen, dp[i]);
            }
        }

        int number=0;

        for(int i=0; i<n; i++)
        {
            if(dp[i]==maxLen)
                number+= count[i];
        }
        return number;
    }
}