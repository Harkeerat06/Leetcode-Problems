class Solution {
    public int helper(int i1, int i2, char[] s1, char[] s2, int memo[][], int n1, int n2)
    {
        if(i1>=n1 || i2>=n2)
            return 0;
        
        if(memo[i1][i2] != -1)
            return memo[i1][i2];
        
        int incFirst= helper(i1+1, i2, s1, s2, memo, n1, n2);
        int incSecond= helper(i1, i2+1, s1, s2, memo, n1, n2);

        int match=0;
        if(s1[i1]==s2[i2])
            match= 1 + helper(i1+1, i2+1, s1, s2, memo, n1, n2);

        return memo[i1][i2]= Math.max(match, Math.max(incFirst, incSecond));
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1= text1.toCharArray();
        char[] s2= text2.toCharArray();
        int n1= s1.length, n2= s2.length;

        int memo[][]= new int[n1][n2];
        for(int i=0; i<n1; i++)
            Arrays.fill(memo[i], -1);

        return helper(0, 0, s1, s2, memo, n1, n2);
    }
}