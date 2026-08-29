class Solution {
    public int gcd(int a, int b) {
        int n1= Math.max(a,b);
        int n2= Math.min(a,b);
        
        while (n2 != 0) 
        {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
    
    public int maxValidSplits(int[] nums) {
        int n= nums.length;
        if(n==1)
            return 0;
        
        int prefix[]= new int[n];
        prefix[0]= nums[0];
        prefix[1]= nums[0];

        for(int i=1; i<n; i++)
            {
                prefix[i]= gcd(prefix[i-1], nums[i]);
            }

        int suffix[]= new int[n];
        suffix[n-2]= nums[n-1];

        for(int i=n-3; i>=0; i--)
            {
               suffix[i]= gcd(suffix[i+1], nums[i+1]);
            }

        int score=0;
        int ans=0;

        // if i remove no element
        for(int i=0; i<n-1; i++)
            {
                if(prefix[i]==suffix[i])
                    score++;
            }

        ans= Math.max(score, ans);
        score=0;
        

        // remove each element once and find prefix suffix
        for(int remIdx=0; remIdx<n; remIdx++)
            {
                int m= n-1;
                int arr[]= new int[m];
                int idx=0;
                for(int i=0; i<n; i++)
                    {
                        if(i==remIdx)
                            continue;
                        arr[idx++]= nums[i];
                    }

                if(m<=1)
                    continue; 
                
                score=0;
                int pre[]= calcPrefix(arr, m);
                int suf[]= calcSuffix(arr, m);

                for(int i=0; i<n-1; i++)
                    {
                        if(pre[i]==suf[i])
                            score++;
                    }
                ans= Math.max(ans, score);
            }
        return ans;
    }

    public int[] calcPrefix(int arr[], int m)
    {
        int prefix[] = new int[m];
        prefix[0] = arr[0];
        
        for(int i=1; i<m; i++)
            prefix[i] = gcd(prefix[i-1], arr[i]);
        return prefix;
    }

    public int[] calcSuffix(int arr[], int m)
    {
        int suffix[] = new int[m];
        suffix[m-1]= -1;
        suffix[m-2]= arr[m-1];
        
        for(int i=m-3; i>=0; i--)
            suffix[i] = gcd(suffix[i+1], arr[i+1]);
        return suffix;
    }
}