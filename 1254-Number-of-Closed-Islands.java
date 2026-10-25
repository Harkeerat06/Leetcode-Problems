class Solution {
    public void dfsMark1(int i, int j, int grid[][], int n, int m, int directions[][])
    {        
        grid[i][j]= 1;

        for(int dir[]: directions)
        {
            int x= i + dir[0];
            int y= j + dir[1];

            if(x<0 || x>=n || y<0 || y>=m)
                continue;

            if(grid[x][y] == 0)
                dfsMark1(x, y, grid, n, m, directions);
        }
    }

    public int closedIsland(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        int directions[][]= {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int i=0; i<n; i++)
        {
            if(grid[i][0] == 0)
                dfsMark1(i, 0, grid, n, m, directions);
            
            if(grid[i][m-1] == 0)
                dfsMark1(i, m-1, grid, n, m, directions);
        }

        for(int i=1; i<m-1; i++)
        {
            if(grid[0][i] == 0)
                dfsMark1(0, i, grid, n, m, directions);
            
            if(grid[n-1][i] == 0)
                dfsMark1(n-1, i, grid, n, m, directions);
        }

        // count  the closed islands
        int count=0;

        for(int i=1; i<n-1; i++)
        {
            for(int j=1; j<m-1; j++)
            {
                if(grid[i][j] == 0)
                {
                    count++;
                    dfsMark1(i, j, grid, n, m, directions);
                }
            }
        }
        return count;
    }
}