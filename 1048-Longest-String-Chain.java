class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        HashMap<String, Integer> map= new HashMap<>();
        map.put(words[0], 0);
        int n= words.length;

        int dp[]= new int[n];
        Arrays.fill(dp, 1);
        int maxLen= 1;

        for(int i=1; i<n; i++)
        {
            int wrdLen= words[i].length();

            for(int j=0; j<wrdLen; j++)
            {
                String first= words[i].substring(0,j);
                String second= words[i].substring(j+1,wrdLen);
                String combined= first+second;

                int idx= map.containsKey(combined) ? map.get(combined) : -1;

                if(idx != -1 && dp[i] <= dp[idx])
                {
                    dp[i]= dp[idx]+1;
                }
                maxLen= Math.max(maxLen, dp[i]);
            }
            map.put(words[i], i);
        }
        return maxLen;
    }
}