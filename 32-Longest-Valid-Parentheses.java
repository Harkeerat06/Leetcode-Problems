class Solution {
    public int longestValidParentheses(String s) {
        int n= s.length();
        if(n==0)
            return 0;
            
        int dp[]= new int[n];
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);

            if(ch=='(')
                stack.push(i);
            
            else if(!stack.isEmpty())
            {
                int pairIdx= stack.pop();
                if(pairIdx!=0)
                {
                    dp[i]= dp[pairIdx-1] + 2 + dp[i-1];
                }
                else
                    dp[i]= dp[i-1] + 2;
            }
        }
        
        int max= dp[0];

        for(int i=1; i<n; i++)
        {
            max= Math.max(dp[i], max);
        }
        return max;
    }
}