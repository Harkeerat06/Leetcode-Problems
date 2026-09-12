class Solution {
    public int HarkeeratHelper(int score, int[] memo, int n, int MAX) {
        if (score==n)
            return 0;

        if (score > n)
            return MAX;

        if (memo[score] != -1)
            return memo[score];

        int ans = MAX;

        for (int k = 1; ; k++) {

            int points = k * (k + 1) / 2;

            if (score + points > n)
                break;

            int takeCurrStreak = (k + 1) + HarkeeratHelper(score + points, memo, n, MAX);

            ans = Math.min(ans, takeCurrStreak);
        }

        return memo[score] = ans;
    }

    public int minDays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int MAX = Integer.MAX_VALUE / 2;  

        return HarkeeratHelper(0, memo, n, MAX) - 1;
    }
}