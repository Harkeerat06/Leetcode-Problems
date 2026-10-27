class Solution {
    HashMap<Integer, Integer> map= new HashMap<>();
    int idArea= 0;
    int directions[][]= {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public void setId(int i, int j, int grid[][], int id, int n, int m)
    {
        grid[i][j]= id;
        idArea++;
        
        for(int dir[]: directions)
        {
            int x= i + dir[0];
            int y= j + dir[1];

            if(x<0 || x>=n || y<0 || y>=m || grid[x][y]!=1)
                continue;
            
            setId(x, y, grid, id, n, m);
        }
    }

    public int findSize(int i, int j, int grid[][], int n, int m)
    {
        int area=0;
        HashSet<Integer> set= new HashSet<>();

        for(int dir[]: directions)
        {
            int x= i + dir[0];
            int y= j + dir[1];

            if(x<0 || x>=n || y<0 || y>=m || grid[x][y]==0 || set.contains(grid[x][y]))
                continue;
            
            area+= map.get(grid[x][y]);
            set.add(grid[x][y]);
        }
        return area+1;
    }

    public int largestIsland(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        int id=2;
        int maxArea= 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==1)
                {
                    setId(i, j, grid, id, n, m);
                    map.put(id, idArea);
                    maxArea= Math.max(maxArea, idArea);
                    idArea= 0;
                    id++;
                }
            }
        }

    
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] != 0)
                    continue;
                
                maxArea= Math.max(maxArea, findSize(i, j, grid, n, m));
            }
        }
        return maxArea;
    }
}