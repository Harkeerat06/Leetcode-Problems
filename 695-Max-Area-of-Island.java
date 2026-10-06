class Solution {
    public int dfs(int i, int j, int grid[][], int n, int m, boolean visit[][], int directions[][])
    {
        visit[i][j]= true;
        int area=0;

        for(int dir[]: directions)
        {
            int x= i + dir[0];
            int y= j + dir[1];

            if(x<0 || x>=n || y<0 || y>=m ||  grid[x][y]==0 || visit[x][y])
                continue;
            
            area+= dfs(x, y, grid, n, m, visit, directions);
        }
        return area+1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        int directions[][]= {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int maxArea= 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==1 && !visit[i][j])
                    maxArea= Math.max(maxArea, dfs(i, j, grid, n, m, visit, directions));
            }
        }
        return maxArea;
    }
}