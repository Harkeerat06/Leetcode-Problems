class Solution {
    public int helper(String s, int idx, int n, int[] memo)
    {
        if(idx>n)
            return 0;
        
        if(memo[idx]!=0)
            return memo[idx];
        
        if(s.charAt(idx)=='0')
            return 0;

        int num=-1;
        if(idx<n-1)
            num= (s.charAt(idx)-'0') * 10 
                    + (s.charAt(idx+1)-'0');

        // take curr dig alone
        memo[idx]+= helper(s, idx+1, n, memo);

        // take curr and next dig as single number
        if(num>=10 && num<=26)
            memo[idx]+= helper(s, idx+2, n, memo);
        
        return memo[idx];
    }

    public int numDecodings(String s) {
        int n= s.length();
        int memo[]= new int[n+1];
        Arrays.fill(memo, 0);
        memo[n]= 1;

        return helper(s, 0, n, memo);
    }
}