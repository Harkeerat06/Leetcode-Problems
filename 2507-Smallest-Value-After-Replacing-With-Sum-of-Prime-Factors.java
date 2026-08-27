class Solution {
    public int smallestValue(int n) {
        if(n==4)
            return 4;
        
        while(true)
        {
            int sum= solve(n);
            if(n==sum)
                return n;
            n= sum;
        }
    }

    public int solve(int n)
    {
        int sum=0;
        
        for(int i=2; i*i<=n; i++)
        {
            while(n%i==0)
            {
                sum+= i;
                n/=i;
            }
        }
        if(n!=1)
            sum+= n;
        return sum;
    }
}