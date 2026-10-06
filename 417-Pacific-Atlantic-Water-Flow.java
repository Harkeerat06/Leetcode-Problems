class Solution {
    public void dfs(int i, int j, int grid[][], int n, int m, boolean visit[][], int countSea[][], int directions[][])
    {
        visit[i][j]= true;
        countSea[i][j]++;

        for(int dir[]: directions)
        {
            int x= i + dir[0];
            int y= j + dir[1];

            if(x<0 || x>=n || y<0 || y>=m || visit[x][y])
                continue;

            if(grid[i][j] <= grid[x][y])
                dfs(x, y, grid, n, m, visit, countSea, directions);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        int countSea[][]= new int[n][m];
        boolean visit[][]= new boolean[n][m];
        int directions[][]= {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // start from leftmost column
        for(int i=0; i<n; i++)
        {
            if(!visit[i][0])
                dfs(i, 0, grid, n, m, visit, countSea, directions);
        }

        // start from topmost row
        for(int i=0; i<m; i++)
        {
            if(!visit[0][i])
                dfs(0, i, grid, n, m, visit, countSea, directions);
        }

        visit= new boolean[n][m];

        // start from last row
        for(int i=m-1; i>=0; i--)
        {
            if(!visit[n-1][i])
                dfs(n-1, i, grid, n, m, visit, countSea, directions);
        }

        // start from last column
        for(int i=n-1; i>=0; i--)
        {
            if(!visit[i][m-1])
                dfs(i, m-1, grid, n, m, visit, countSea, directions);
        }

        List<List<Integer>> ans= new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(countSea[i][j]==2)
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
}