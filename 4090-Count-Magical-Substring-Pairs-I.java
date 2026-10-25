class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int[][] countDistinct = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;

            for (int j = i; j < n; j++) {
                if (freq[s.charAt(j) - 'a'] == 0)
                    distinct++;

                freq[s.charAt(j) - 'a']++;
                countDistinct[i][j] = distinct;
            }
        }

        int ans = 0;

        for (int j = 0; j < n - 1; j++) {
            int[] left = new int[n + 1];
            int[] right = new int[n + 1];

            for (int i = 0; i <= j; i++)
                left[countDistinct[i][j]]++;

            for (int k = j + 1; k < n; k++)
                right[countDistinct[j + 1][k]]++;

            for (int d = 1; d <= n; d++)
                ans += left[d] * right[d];
        }

        return ans;
    }
}