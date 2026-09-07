class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n= arr.length;

        int dp[]= new int[n];
        Arrays.fill(dp, 1);

        int parent[]= new int[n];
        Arrays.fill(parent, -1);

        int maxLen= 1, maxIdx=0;

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(dp[i] <= dp[j] && arr[i] % arr[j] == 0)
                {
                    dp[i]= dp[j]+1;
                    parent[i]= j;
                    
                    if(maxLen < dp[i])
                    {
                        maxIdx= i;
                        maxLen= dp[i];
                    }
                }
            }
        }

        List<Integer> ans= new ArrayList<>();
        while(maxIdx>=0)
        {
            ans.add(arr[maxIdx]);
            maxIdx= parent[maxIdx];
        }
        return ans;
    }
}