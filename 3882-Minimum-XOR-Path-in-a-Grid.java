class Solution {
    int[][] moves = {{0, 1}, {1, 0}};

    boolean[][][] memo;
    boolean[][] computed;
    int[][] grid;
    int n, m;

    void dfs(int i, int j) {
        if (computed[i][j])
            return;

        computed[i][j] = true;

        // Base case: destination
        if (i == n - 1 && j == m - 1) {
            memo[i][j][grid[i][j]] = true;
            return;
        }

        for (int[] dir : moves) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= n || y >= m)
                continue;

            dfs(x, y);

            // Combine this cell with every possible XOR
            // achievable from the neighboring cell.
            for (int k = 0; k < 1024; k++) {
                if (memo[x][y][k]) {
                    int newXor = grid[i][j] ^ k;
                    memo[i][j][newXor] = true;
                }
            }
        }
    }

    public int minCost(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        memo = new boolean[n][m][1024];
        computed = new boolean[n][m];

        dfs(0, 0);

        for (int k = 0; k < 1024; k++) {
            if (memo[0][0][k])
                return k;
        }

        return -1;
    }
}