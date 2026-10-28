class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] dp = new boolean[n][m][1024];

        // Base case: path containing only the starting cell
        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Skip the starting cell; already initialized
                if (i == 0 && j == 0)
                    continue;

                // Paths coming from above
                if (i > 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (dp[i - 1][j][k]) {
                            int newXor = k ^ grid[i][j];
                            dp[i][j][newXor] = true;
                        }
                    }
                }

                // Paths coming from the left
                if (j > 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (dp[i][j - 1][k]) {
                            int newXor = k ^ grid[i][j];
                            dp[i][j][newXor] = true;
                        }
                    }
                }
            }
        }

        // Find the minimum achievable XOR at the destination
        for (int k = 0; k < 1024; k++) {
            if (dp[n - 1][m - 1][k])
                return k;
        }

        return -1;
    }
}